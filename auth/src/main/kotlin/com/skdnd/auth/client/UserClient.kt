package com.skdnd.auth.client

import com.skdnd.auth.dto.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "user")
interface UserClient {

    @GetMapping("/user/{id}")
    suspend fun getUserById(@PathVariable id: Int): ResponseEntity<User>
}
