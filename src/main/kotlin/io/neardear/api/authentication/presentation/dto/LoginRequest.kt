package io.neardear.api.authentication.presentation.dto

data class LoginRequest(
    val email: String,
    val password: String
)
