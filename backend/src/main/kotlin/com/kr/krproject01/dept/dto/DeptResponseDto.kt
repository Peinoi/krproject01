package com.kr.krproject01.dept.dto

import com.kr.krproject01.dept.entity.Dept


data class DeptResponseDto(
    val id: Int?,
    val deptName: String?,
) {
    companion object {
        fun from(dept: Dept) = DeptResponseDto(
            id = dept.id,
            deptName = dept.deptName,
        )
    }
}
