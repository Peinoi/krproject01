package com.kr.krproject01.user.dto

import com.kr.krproject01.user.entity.User
import java.time.LocalDate

data class UserResponseDto(
    val id: Int?,
    val userId: String?,
    val useUser: Boolean?,
    val crDate: LocalDate?,
    val endDate: LocalDate?,
    val role: String?,
) {
    companion object {
        fun from(user: User) = UserResponseDto(
            id = user.id,
            userId = user.userId,
            useUser = user.useUser,
            crDate = user.crDate,
            endDate = user.endDate,
            role = user.role,
        )
    }
}
