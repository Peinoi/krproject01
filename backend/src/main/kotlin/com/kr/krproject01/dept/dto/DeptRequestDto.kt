package com.kr.krproject01.dept.dto

import com.kr.krproject01.dept.entity.Dept

data class DeptRequestDto(
    val deptName: String,
) {
    fun toEntity() = Dept(
        deptName = this.deptName,
    )
}
