package io.neardear.api.merchant.presentation

import io.neardear.api.merchant.presentation.dto.UpdateMerchantRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity

@Tag(name = "Merchant", description = "상점 도메인 API")
interface MerchantSpecification {
    @Operation(
        summary = "상점 수정 api",
        description = "파트너 회원이 등록한 상점의 정보를 수정하는 EndPoint를 제공합니다.")
    @ApiResponse(responseCode = "200", description = "상점 수정 성공")
    fun updateMerchant(updateMerchantRequest: UpdateMerchantRequest): ResponseEntity<Void>
}