package com.kr.krproject01.chart.repository

import com.kr.krproject01.chart.dto.ChartStatusDto
import com.kr.krproject01.chart.dto.DeptDetailDto
import com.kr.krproject01.chart.entity.Chart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ChartRepository : JpaRepository<Chart, Long> {

    @Query(
        """
        SELECT new com.kr.krproject01.chart.dto.ChartStatusDto(c.status, COUNT(c))
        FROM Chart c
        GROUP BY c.status
        """
    )
    fun countByStatus(): List<ChartStatusDto>

    @Query(
        """
        SELECT new com.kr.krproject01.chart.dto.DeptDetailDto(u.role, c.status, COUNT(c))
        FROM Chart c
        JOIN User u ON c.userId = u.id
        WHERE u.dept.deptName = :deptName
        GROUP BY u.role, c.status
        """
    )
    fun countByDeptDetail(deptName: String): List<DeptDetailDto>

    @Query(
        """
        SELECT DISTINCT u.dept.deptName
        FROM User u
        WHERE u.dept IS NOT NULL
        """
    )
    fun findAllDeptNames(): List<String>
}
