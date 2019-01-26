package com.example.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name="users")
class Users (
        @Column
        val name: String,
        @Column
        var rating: Int,
        @Column
        @Temporal(TemporalType.TIME)
        val create_date: Date,
        @Column
        @Temporal(TemporalType.TIME)
        var update_date: Date
) : AbstractEntity<Int>()
