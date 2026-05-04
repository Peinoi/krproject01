package com.kr.krproject01.chart.dto

data class ChartStatusDto(
    val status: String,
    val count: Long,
)

data class DeptChartDto(
    val deptName: String,
    val total: Long,
    val details: List<DeptDetailDto>,
)

data class DeptDetailDto(
    val role: String,
    val status: String,
    val count: Long,
)
