package com.kr.krproject01.user.service

import com.kr.krproject01.user.dto.UserResponseDto
import com.kr.krproject01.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    // 전체 조회
    fun findAll(): List<UserResponseDto> =
        userRepository.findAll().map { UserResponseDto.from(it) }

    // 단건 조회
    fun findById(id: Int): UserResponseDto {
        val user = userRepository.findById(id)
            .orElseThrow { NoSuchElementException("유저를 찾을 수 없습니다. id=$id") }
        return UserResponseDto.from(user)
    }


}
