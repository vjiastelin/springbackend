package com.example.controller

import com.example.entities.Users
import com.example.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/backend")
class BackendController @Autowired constructor(private val usersRepository : UsersRepository) {


    @GetMapping("/hello")
    @ResponseBody
    fun hello() : String{
        return "Hello from Spring!!"
    }

    @GetMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun createUser(@RequestParam name : String) : String{
        val user = Users(name,0, LocalDateTime.now(),LocalDateTime.now())
        usersRepository.save(user)
        return "User with name $name has been created"
    }

    @GetMapping("/user/{name}")
    @ResponseBody
    fun getUserByName(@PathVariable("name") name : String) : Users{
        return usersRepository.findByName(name)[0]
    }

    @PostMapping("/user/{name}")
    @ResponseBody
    fun getUserByNamePost(@PathVariable("name") name : String) : Users{
        return usersRepository.findByName(name)[0]
    }

    @GetMapping("/user/{userid}/{rating}")
    @ResponseBody
    fun setUserRating(@PathVariable("userid") userid : Int,
                      @PathVariable("rating") rating : Int
    ) : String {
        val user = usersRepository.getOne(userid)
       user.let {
           user.rating = rating
           user.update_date = LocalDateTime.now()
           usersRepository.save(user)
           return "Rating for user has been set to $rating"
       }
    }


}