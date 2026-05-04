package com.kr.krproject01.chart.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "chart")
class Chart(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "status")
    val status: String,

    @Column(name = "cr_date")
    val crDate: String,

    @Column(name = "user_id")
    val userId: Int,  // Long → Int 로 변경 (User.id 타입과 일치)
)
