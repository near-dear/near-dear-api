package io.neardear.api.authentication.infrastructure.jwt

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class JwtProperties(
    @Value("\${app.security.jwt.tokenExpirationSec}")
    val tokenExpirationSec: String,
    @Value("\${app.security.jwt.refreshExpirationSec}")
    val refreshExpirationSec: String,
    @Value("\${app.security.jwt.tokenIssuer}")
    val tokenIssuer: String,
    @Value("\${app.security.jwt.base64TokenSigningKey}")
    val base64TokenSigningKey: String,
)