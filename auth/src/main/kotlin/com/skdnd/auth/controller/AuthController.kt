package com.skdnd.auth.controller

import com.skdnd.auth.dto.User
import com.skdnd.auth.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(private val userService: UserService) {

  @GetMapping
  suspend fun getDemo(): String {
    return "auth"
  }

  //  @GetMapping("/user/{id}")
  //  suspend fun getUserById(@PathVariable id: Int): ResponseEntity<User> {
  //    return userService.getUserById(id)
  //  }
}