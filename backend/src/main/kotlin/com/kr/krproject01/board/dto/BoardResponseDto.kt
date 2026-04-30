package com.kr.krproject01.board.dto

import com.kr.krproject01.board.entity.Board
import java.time.LocalDate

data class BoardResponseDto(
    val id: Int?,
    val title: String,
//    val content: String,
    val crDate: LocalDate,
    val userId: String,
) {

    companion object {

        fun from(board: Board): BoardResponseDto {
            return BoardResponseDto(
                id = board.id,
                title = board.title,
                //content = board.content,
                crDate = board.crDate,
                userId = board.user.userId,
            )
        }
    }


}


