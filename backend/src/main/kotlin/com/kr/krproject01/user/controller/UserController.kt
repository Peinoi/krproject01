package com.kr.krproject01.user.controller

import com.kr.krproject01.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {

    @GetMapping("/users")
    fun list() = userService.findAll()

}
