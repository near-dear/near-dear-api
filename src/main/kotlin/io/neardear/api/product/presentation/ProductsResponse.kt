package io.neardear.api.product.presentation

data class ProductsResponse(
    val productName: String,
    val regionName: String,
    val price: Int
)
