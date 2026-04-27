package com.kr.krproject01.user.repository

import com.kr.krproject01.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int>
