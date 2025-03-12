package com.skdnd.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {

  @GetMapping
  fun getUser(): String {
    return "Hello, this is a user!"
  }
}