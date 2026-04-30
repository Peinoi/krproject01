package com.kr.krproject01.board.repository

import com.kr.krproject01.board.entity.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface BoardRepository : JpaRepository<Board, Int> {
    @Query("""SELECT b FROM Board b WHERE b.useYn = true""")
    fun findByBoard(pageable: Pageable): Page<Board>
}

