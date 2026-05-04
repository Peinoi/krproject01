package com.kr.krproject01.board.controller

import com.kr.krproject01.board.dto.BoardResponseDto
import com.kr.krproject01.board.service.BoardService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/boards")
class BoardController(
    private val boardService: BoardService,
) {
    @GetMapping
    fun list(
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "2") size: Int,
        @RequestParam(required = false) keyword: String?,
    ): Page<BoardResponseDto> {
        return boardService.findAll(page, size, keyword)
    }
}

