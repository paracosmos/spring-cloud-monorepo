package com.skdnd.user.repository

import com.skdnd.user.entity.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.springframework.stereotype.Repository

@Repository
class UserRepository {

    suspend fun getUserById(id: Int): User? = newSuspendedTransaction(Dispatchers.IO) {
        Users.selectAll().where { Users.id eq id }
            .map { row -> User(row[Users.id].value, row[Users.name], row[Users.password]) }
            .singleOrNull()
    }

    suspend fun addUser(name: String, password: String): Int = newSuspendedTransaction(Dispatchers.IO) {
        Users.insertAndGetId {
            it[Users.name] = name
            it[Users.password] = password
        }.value
    }

}