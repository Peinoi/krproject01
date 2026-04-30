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
    fun findAll(page: Int, size: Int): Page<BoardResponseDto> {
        // PageRequest는 0-based index이므로 page - 1 처리
        val pageable = PageRequest.of(page - 1, size)

        val boards = boardRepository.findByBoard(pageable)

        // Entity를 DTO로 변환
        return boards.map { BoardResponseDto.from(it) }
    }
}
