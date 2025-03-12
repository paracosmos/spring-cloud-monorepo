package com.skdnd.auth.service

import com.skdnd.auth.client.UserClient
import com.skdnd.auth.dto.User
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(private val userClient: UserClient) {

    suspend fun getUserById(id: Int): ResponseEntity<User> {
        return userClient.getUserById(id)
    }
}
