package com.kr.krproject01.chart.service

import com.kr.krproject01.chart.dto.ChartStatusDto
import com.kr.krproject01.chart.dto.DeptChartDto
import com.kr.krproject01.chart.mapper.toDeptChartDto
import com.kr.krproject01.chart.repository.ChartRepository
import org.springframework.stereotype.Service

@Service
class ChartService(
    private val chartRepository: ChartRepository,
) {
    fun getStatusChart(): List<ChartStatusDto> {
        return chartRepository.countByStatus()
    }

    fun getDeptChart(): List<DeptChartDto> {
        val deptNames = chartRepository.findAllDeptNames()
        return deptNames.map { deptName ->
            val details = chartRepository.countByDeptDetail(deptName)
            details.toDeptChartDto(deptName)  // 확장함수 사용
        }
    }
}
