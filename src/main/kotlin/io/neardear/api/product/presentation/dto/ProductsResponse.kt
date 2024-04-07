package io.neardear.api.product.presentation.dto

data class ProductsResponse(
    val productName: String,
    val regionName: String,
    val price: Int
)
