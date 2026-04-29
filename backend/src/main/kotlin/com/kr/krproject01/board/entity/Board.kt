package com.kr.krproject01.board.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "board")
class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(name = "title")
    var title: String? = null

    @Column(name = "content")
    var content: String? = null

    @Column(name = "cr_date")
    var crDate: String? = null

    @Column(name = "user_id")
    var userId: String? = null

}
