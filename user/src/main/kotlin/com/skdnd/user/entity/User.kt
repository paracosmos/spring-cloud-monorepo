package com.skdnd.user.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
//import org.jetbrains.exposed.sql.Table
/*
#DDL
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
*/

object Users : IntIdTable("users") {
    val name = varchar("name", 255)
    val password = varchar("password", 255)
}

class UserEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserEntity>(Users)
    var name by Users.name
    var password by Users.password
    fun toDomain() = User(id.value, name, password)
}

data class User(
    val id: Int,
    val name: String,
    val password: String
)