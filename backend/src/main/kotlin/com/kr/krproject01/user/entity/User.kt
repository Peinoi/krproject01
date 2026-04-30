package com.kr.krproject01.user.entity

import com.kr.krproject01.dept.entity.Dept
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "user")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "user_id")
    var userId: String,

    @Column(name = "pass_hash")
    var passHash: String,

    @Column(name = "use_user")
    var useUser: Boolean,

    @Column(name = "cr_date")
    var crDate: LocalDate?,

    @Column(name = "end_date")
    var endDate: LocalDate?,

    var role: String?,


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    var dept: Dept,

    )

