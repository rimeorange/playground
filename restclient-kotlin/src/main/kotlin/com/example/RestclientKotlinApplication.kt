package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestclientKotlinApplication

fun main(args: Array<String>) {
    runApplication<RestclientKotlinApplication>(*args)
}
