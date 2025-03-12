package com.skdnd.user.controller

import com.skdnd.user.entity.User
import org.springframework.web.bind.annotation.*
import com.skdnd.user.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/user")
class UserController(
  private val repository: UserRepository
) {

  @GetMapping
  suspend fun getUser(): String {
    return "Hello, this is a user!"
  }

  @GetMapping("/{id}")
  suspend fun getUserById(@PathVariable id: Int): Map<String, Any?> {
    val user = repository.getUserById(id) ?: throw ResponseStatusException(
      HttpStatus.NOT_FOUND, "User not found"
    )
    return mapOf(
      "id" to user[User.id],
      "name" to user[User.name],
      "password" to user[User.password]
    )
  }

  @PostMapping
  suspend fun addUser(@RequestBody request: Map<String, String>): Int {
    val name = request["name"] ?: throw IllegalArgumentException("Name is required")
    val password = request["password"] ?: throw IllegalArgumentException("Password is required")
    return repository.addUser(name, password)
  }
}