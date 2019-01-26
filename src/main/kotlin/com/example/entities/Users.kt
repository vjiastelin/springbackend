package com.example.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="users")
class Users (
        @Column
        val name: String,
        @Column
        var rating: Int,
        @Column
        val create_date: LocalDateTime,
        @Column
        var update_date: LocalDateTime
) : AbstractEntity<Int>()
