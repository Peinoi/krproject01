package com.kr.krproject01.board.service

import com.kr.krproject01.board.dto.BoardResponseDto
import com.kr.krproject01.board.repository.BoardRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService(
    private val boardRepository: BoardRepository,
) {
    @Transactional(readOnly = true)
    fun findAll(page: Int, size: Int, keyword: String?): Page<BoardResponseDto> {
        val pageable = PageRequest.of(page - 1, size)

        val boards = boardRepository.searchBoards(keyword, pageable)

        return boards.map { BoardResponseDto.from(it) }
    }
    
}
