package io.neardear.api.product.presentation

import io.neardear.api.authentication.presentation.API_VERSION
import io.neardear.api.product.presentation.dto.ProductDetailResponse
import io.neardear.api.product.presentation.dto.ProductRegisterRequest
import io.neardear.api.product.presentation.dto.ProductSpecification
import io.neardear.api.product.presentation.dto.ProductsResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping(API_VERSION)
class ProductApi: ProductSpecification {

    @GetMapping
    override fun getProducts(page: Int, size: Int): ResponseEntity<List<ProductsResponse>> {
        return ResponseEntity.ok(listOf(
            ProductsResponse("상품1", "지역1", 10000),
            ProductsResponse("상품2", "지역2", 10000),
            ProductsResponse("상품3", "지역3", 10000),
        ))
    }

    @PostMapping
    override fun registerProduct(productRegisterRequest: ProductRegisterRequest): ResponseEntity<Void> {
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{productTsId}")
    override fun getProductDetail(@PathVariable productTsId: Long): ResponseEntity<ProductDetailResponse> {
        return ResponseEntity.ok(
            ProductDetailResponse(
            "상점1",
            "상품1",
            "지역1",
            10000,
            1,
            listOf("이미지1", "이미지2", "이미지3"),
            "카테고리1",
            LocalDateTime.of(2024, 4, 8, 12, 10, 12))
        )
    }
}