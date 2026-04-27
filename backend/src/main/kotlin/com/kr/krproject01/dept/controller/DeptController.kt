package com.kr.krproject01.dept.controller

import com.kr.krproject01.dept.service.DeptService

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/depts")
class DeptController(
    private val deptService: DeptService,
) {

    @GetMapping("")
    fun list() = deptService.findAll()

}
