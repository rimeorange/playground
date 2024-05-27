package com.restclient.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class RestClientV1 {

    public void sendRestCientString() {
        RestClient restClient = RestClient.create();

        String data = restClient.get()
                .uri("")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(String.class);


        log.info("data : {}", data);
    }

}
