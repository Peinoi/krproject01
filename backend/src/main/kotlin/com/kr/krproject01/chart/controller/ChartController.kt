package com.kr.krproject01.chart.controller

import com.kr.krproject01.chart.dto.ChartStatusDto
import com.kr.krproject01.chart.dto.DeptChartDto
import com.kr.krproject01.chart.service.ChartService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/charts")
class ChartController(
    private val chartService: ChartService,
) {

    @GetMapping("/status")
    fun getStatusChart(): List<ChartStatusDto> {
        return chartService.getStatusChart()
    }

    @GetMapping("/dept")
    fun getDeptChart(): List<DeptChartDto> {
        return chartService.getDeptChart()
    }
}
