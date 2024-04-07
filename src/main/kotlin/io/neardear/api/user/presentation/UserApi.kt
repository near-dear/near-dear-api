package io.neardear.api.user.presentation

import io.neardear.api.user.presentation.dto.MyPageResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(API_VERSION)
class UserApi: UserSpecification {
    @GetMapping(MY_PAGE)
    override fun myPage(): ResponseEntity<MyPageResponse> {
        return ResponseEntity.ok(MyPageResponse("사용자1", "useremail1@domain.com"))
    }
}