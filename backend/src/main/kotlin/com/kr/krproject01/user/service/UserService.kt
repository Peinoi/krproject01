package com.kr.krproject01.user.service

import com.kr.krproject01.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun findAll() = userRepository.findAll()

}
