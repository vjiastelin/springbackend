package com.example.repositories

import com.example.entities.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface UsersRepository : JpaRepository<Users,Int> {
    fun findByName(@Param("name") name : String) : List<Users>
}