package com.kr.krproject01.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "user")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "user_id")
    val userId: String?,

    @Column(name = "pass_hash")
    val passHash: String?,

    @Column(name = "use_user")
    val useUser: Boolean?,

    @Column(name = "cr_date")
    val crDate: LocalDate?,

    @Column(name = "end_date")
    val endDate: LocalDate?,

    val role: String?,


    )
