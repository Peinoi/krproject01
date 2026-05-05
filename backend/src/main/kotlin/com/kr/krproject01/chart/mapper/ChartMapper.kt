// com/kr/krproject01/chart/mapper/ChartMapper.kt
package com.kr.krproject01.chart.mapper

import com.kr.krproject01.chart.dto.ChartStatusDto
import com.kr.krproject01.chart.dto.DeptChartDto
import com.kr.krproject01.chart.dto.DeptDetailDto
import com.kr.krproject01.chart.entity.Chart

// Entity → DTO
fun Chart.toStatusDto(count: Long) = ChartStatusDto(
    status = this.status,
    count = count,
)

// DeptDetail 리스트 → DeptChartDto 조합
fun List<DeptDetailDto>.toDeptChartDto(deptName: String) = DeptChartDto(
    deptName = deptName,
    total = this.sumOf { it.count },
    details = this,
)
