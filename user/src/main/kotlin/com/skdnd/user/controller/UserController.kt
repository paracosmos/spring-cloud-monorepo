package com.skdnd.user.controller

import com.skdnd.user.entity.User
import com.skdnd.user.service.UserService
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/user")
class UserController(
  private val userService: UserService
) {

  @GetMapping
  suspend fun getUser(): String {
    return "Hello, this is a user!"
  }

  @GetMapping("/{id}")
  suspend fun getUserById(@PathVariable id: Int): User {
    return userService.getUserById(id) ?: throw ResponseStatusException(
      HttpStatus.NOT_FOUND, "User not found"
    )
  }

  @PostMapping
  suspend fun addUser(@RequestBody request: Map<String, String>): Int {
    val name = request["name"] ?: throw IllegalArgumentException("Name is required")
    val password = request["password"] ?: throw IllegalArgumentException("Password is required")
    return userService.addUser(name, password)
  }
}
