package io.neardear.api.authentication.presentation

import io.neardear.api.authentication.domain.Role
import io.neardear.api.authentication.infrastructure.jwt.JwtTokenProvider
import io.neardear.api.authentication.presentation.dto.LoginRequest
import io.neardear.api.authentication.presentation.dto.LoginResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(API_VERSION)
class AuthenticationApi(
    private val jwtTokenProvider: JwtTokenProvider
) {
    @PostMapping(LOGIN)
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<LoginResponse> {
        jwtTokenProvider.generate(loginRequest.email, setOf(Role.USER))
        return ResponseEntity.ok(LoginResponse(loginRequest.email, loginRequest.email))
    }
}