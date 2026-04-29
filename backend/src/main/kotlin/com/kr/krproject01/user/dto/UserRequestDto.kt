package com.kr.krproject01.user.dto

import com.kr.krproject01.dept.entity.Dept
import com.kr.krproject01.user.entity.User
import java.time.LocalDate

data class UserRequestDto(
    val userId: String,
    val password: String,
    val role: String = "USER",
    val dept: Dept,
) {
    fun toEntity() = User(
        userId = this.userId,
        passHash = password, // 일단은 입력받은 비밀번호를 그대로 저장
        useUser = true,
        crDate = LocalDate.now(),
        endDate = null,
        role = this.role,
        dept = dept,
    )
}
