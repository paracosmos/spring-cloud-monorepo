package com.skdnd.user.entity

import org.jetbrains.exposed.sql.Table

/*
#DDL
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
 */

object User : Table("users") {
    val id = integer("id").autoIncrement()
    override val primaryKey = PrimaryKey(id)
    val name = varchar("name", 255)
    val password = varchar("password", 255)
}