package io.neardear.api.authentication.presentation.dto

data class UserSignUpRequest(
    val email: String,
    val password: String,
    val passwordConfirm: String,
    val nickname: String,
    val phoneNumber: String
)
