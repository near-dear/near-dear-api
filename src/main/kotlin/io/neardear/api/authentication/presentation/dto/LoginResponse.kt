package io.neardear.api.authentication.presentation.dto

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String
)
