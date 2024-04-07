package io.neardear.api.product.presentation.dto

import java.math.BigDecimal

data class ProductRegisterRequest(
    val productName: String,
    val retailPrice: BigDecimal,
    val discountRate: BigDecimal,
    val quantity: Int,
    val thumbNails: List<String>,
    val category: String
)
