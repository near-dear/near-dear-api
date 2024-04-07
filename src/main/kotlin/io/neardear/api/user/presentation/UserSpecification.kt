package io.neardear.api.user.presentation

import io.neardear.api.user.presentation.dto.MyPageResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity

@Tag(name = "User", description = "사용자 도메인 API")
interface UserSpecification {

    @Operation(
    summary = "마이페이지",
    description = "사용자의 마이페이지를 제공하는 EndPoint를 제공합니다.")
    @ApiResponse(responseCode = "200", description = "마이페이지 조회 성공")
    fun myPage(): ResponseEntity<MyPageResponse>
}