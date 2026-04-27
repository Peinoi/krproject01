package com.kr.krproject01.dept.service

import com.kr.krproject01.dept.dto.DeptResponseDto
import com.kr.krproject01.dept.repository.DeptRepository
import org.springframework.stereotype.Service

@Service
class DeptService(
    private val deptRepository: DeptRepository,
) {

    fun findAll(): List<DeptResponseDto> =
        deptRepository.findAll().map { DeptResponseDto.from(it) }

}
