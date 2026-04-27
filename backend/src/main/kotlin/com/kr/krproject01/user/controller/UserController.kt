package com.kr.krproject01.user.controller

import com.kr.krproject01.user.dto.UserResponseDto
import com.kr.krproject01.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
) {

    // GET /users
    @GetMapping
    fun list(): ResponseEntity<List<UserResponseDto>> =
        ResponseEntity.ok(userService.findAll())

    // GET /users/{id}
    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Int): ResponseEntity<UserResponseDto> =
        ResponseEntity.ok(userService.findById(id))

}
