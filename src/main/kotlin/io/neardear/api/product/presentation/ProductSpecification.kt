package io.neardear.api.product.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity

@Tag(name = "Product", description = "상품 목록 API")
interface ProductSpecification {
    @Operation(
        summary = "상품 목록 조회",
        description = "상품 목록을 조회하는 EndPoint를 제공합니다.")
    @ApiResponse(responseCode = "200", description = "상품 조회 성공")
    @Parameter(name = "page", description = "페이지 번호", required = false, example = "0")
    @Parameter(name = "size", description = "페이지 크기", required = false, example = "10")
    fun getProducts(page: Int, size: Int): ResponseEntity<List<ProductsResponse>>

    @Operation(
        summary = "상품 상세 조회",
        description = "상품 상세를 조회하는 EndPoint를 제공합니다.")
    @ApiResponse(responseCode = "200", description = "상품 상세 조회 성공")
    @Parameter(name = "productTsId", description = "상품 TS ID", required = true, example = "1")
    fun getProductDetail(productTsId: Long): ResponseEntity<ProductDetailResponse>
}