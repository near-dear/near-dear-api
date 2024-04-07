package io.neardear.api.merchant.presentation.dto

data class UpdateMerchantRequest(
    val merchantName: String,
    val merchantAddress: String,
    val businessNumber: String,
    val merchantThumbNails: List<String>
)
