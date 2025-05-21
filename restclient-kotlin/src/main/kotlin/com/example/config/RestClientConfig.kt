package com.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig {

    @Bean
    fun restClientBuilder(): RestClient.Builder {
        return RestClient.builder()
            .baseUrl("https://api.agify.io") //이름으로 나이 추정 API
    }
}