package com.example.client

import com.example.dto.AgifyResponse
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class RestClient (
    private val builder: RestClient.Builder
){
    fun getAgePrediction(name: String) : AgifyResponse {
        val client = builder.build()
        return client.get()
            .uri { uriBuilder -> uriBuilder.queryParam("name", name).build() }
            .retrieve()
            .body(AgifyResponse::class.java)!!
    }

}