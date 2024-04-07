package io.neardear.api.product.presentation.dto

import java.time.LocalDateTime

data class ProductDetailResponse(
    val merchantName: String,
    val productName: String,
    val regionName: String,
    val price: Int,
    val quantity: Int,
    val thumbNails: List<String>,
    val category: String,
    val createTime: LocalDateTime,
)
