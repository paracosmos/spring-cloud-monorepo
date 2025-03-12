package com.skdnd.user.repository

import com.skdnd.user.entity.User
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class UserRepository {

    fun addUser(name: String, password: String): Int {
        return transaction {
            User.insert {
                it[User.name] = name
                it[User.password] = password
            } get User.id
        }
    }

    fun getUserById(userId: Int): ResultRow? {
        return transaction {
            User.select { User.id eq userId }.singleOrNull()
        }
    }

    fun updateUserPassword(userId: Int, newPassword: String): Int {
        return transaction {
            User.update({ User.id eq userId }) {
                it[password] = newPassword
            }
        }
    }

}