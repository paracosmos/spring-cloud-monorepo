package com.skdnd.user

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class UserApplication

fun main(args: Array<String>) {
	runApplication<UserApplication>(*args)
}
