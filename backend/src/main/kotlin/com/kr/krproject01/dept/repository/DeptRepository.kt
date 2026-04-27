package com.kr.krproject01.dept.repository

import com.kr.krproject01.dept.entity.Dept
import org.springframework.data.jpa.repository.JpaRepository

interface DeptRepository : JpaRepository<Dept, Int>
