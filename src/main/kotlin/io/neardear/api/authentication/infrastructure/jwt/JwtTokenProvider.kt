package io.neardear.api.authentication.infrastructure.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import io.neardear.api.authentication.domain.Role
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import kotlin.collections.HashMap

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties
) {

    fun generate(email: String, roles: Set<Role>): JwtTokens {
        return JwtTokens(generateAccessToken(email, roles), generateRefreshToken(email))
    }

    private fun generateAccessToken(email: String, roles: Set<Role>): String {
        val claims = HashMap<String, Any>()
        claims["email"] = email
        claims["scopes"] = getAuthorities(roles)
        val currentTime = LocalDateTime.now()
        val key = Keys.hmacShaKeyFor(jwtProperties.base64TokenSigningKey.toByteArray(StandardCharsets.UTF_8))

        return Jwts.builder()
            .claims(claims)
            .issuer(jwtProperties.tokenIssuer)
            .issuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
            .expiration(Date.from(currentTime.plusSeconds(jwtProperties.refreshExpirationSec.toLong())
                .atZone(ZoneId.systemDefault()).toInstant()))
            .signWith(key)
            .compact()
    }

    private fun generateRefreshToken(email: String): String {
        val claims = HashMap<String, Any>()
        claims["email"] = email
        claims["scopes"] = listOf("REFRESH_TOKEN")
        val randomJti = UUID.randomUUID().toString()
        val currentTime = LocalDateTime.now()
        val key = Keys.hmacShaKeyFor(jwtProperties.base64TokenSigningKey.toByteArray(StandardCharsets.UTF_8))

        return Jwts.builder()
            .claims(claims)
            .issuer(jwtProperties.tokenIssuer)
            .issuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
            .expiration(Date.from(currentTime.plusSeconds(jwtProperties.refreshExpirationSec.toLong())
                .atZone(ZoneId.systemDefault()).toInstant()))
            .id(randomJti)
            .signWith(key)
            .compact()
    }

    private fun getAuthorities(roles: Set<Role>): List<String> {
        return roles.map { "ROLE_${it.name}" }
    }
}