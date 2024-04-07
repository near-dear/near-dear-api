package io.neardear.api.authentication.presentation.dto

data class PartnerSignUpRequest(
    val email: String,
    val password: String,
    val passwordConfirm: String,
    val phoneNumber: String,
    val merchantName: String,
    val businessNumber: String,
    val businessContactNumber: String
)
