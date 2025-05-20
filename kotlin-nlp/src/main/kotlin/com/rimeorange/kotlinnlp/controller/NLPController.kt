package com.rimeorange.kotlinnlp.controller

import com.rimeorange.kotlinnlp.dto.SentimentRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient

@RestController
@RequestMapping("/nlp")
class NLPController (
    private val webClient: WebClient
){
    @PostMapping("/sentiment")
    fun analyzeSentiment(@RequestBody request: SentimentRequest) : ResponseEntity<Any> {
        val response = webClient.post()
            .uri("analyze")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(Map::class.java)
            .block()
        return ResponseEntity.ok().body(response)

    }
}