package com.skdnd.user.service

import com.skdnd.user.entity.User
import com.skdnd.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    suspend fun getUserById(id: Int): User? {
        return userRepository.getUserById(id)
    }

    suspend fun addUser(name: String, password: String): Int {
        return userRepository.addUser(name, password)
    }
}
