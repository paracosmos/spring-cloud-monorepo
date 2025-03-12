package com.skdnd.user.controller

import com.skdnd.user.entity.User
import com.skdnd.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
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
  suspend fun getUserById(@PathVariable id: Int): ResponseEntity<User> {
    val user = userService.getUserById(id)
      ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
    return ResponseEntity.ok(user)
  }

  @PostMapping
  suspend fun addUser(@RequestBody request: Map<String, String>): ResponseEntity<Map<String, Int>> {
    val name = request["name"] ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is required")
    val password = request["password"] ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is required")
    val id = userService.addUser(name, password)
    return ResponseEntity.status(HttpStatus.CREATED)
      .body(mapOf("id" to id))
  }

}
