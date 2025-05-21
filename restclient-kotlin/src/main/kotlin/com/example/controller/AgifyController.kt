package com.example.controller

import com.example.client.RestClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/agify")
class AgifyController (
    private val restClient: RestClient
){

    @GetMapping
    fun getAge(@RequestParam name: String): ResponseEntity<Any> {
        val result = restClient.getAgePrediction(name)
        return ResponseEntity.ok(result)
    }
}