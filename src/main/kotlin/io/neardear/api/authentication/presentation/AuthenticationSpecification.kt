package io.neardear.api.authentication.presentation

import io.neardear.api.authentication.presentation.dto.LoginRequest
import io.neardear.api.authentication.presentation.dto.LoginResponse
import io.neardear.api.authentication.presentation.dto.SignUpRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "Authentication", description = "인증 API")
interface AuthenticationSpecification {

    @Operation(
        summary = "로그인",
        description = "회원가입 완료 사용자가 로그인하는 EndPoint를 제공합니다.")
    @ApiResponse(responseCode = "200", description = "로그인 성공")
    fun login(loginRequest: LoginRequest): ResponseEntity<LoginResponse>

    @Operation(summary = "회원가입", description = "사용자가 회원가입하기 위한 Endpoint를 제공합니다.")
    @ApiResponse(responseCode = "201", description = "회원가입 성공")
    fun signUp(signUpRequest: SignUpRequest): ResponseEntity<Void>
}