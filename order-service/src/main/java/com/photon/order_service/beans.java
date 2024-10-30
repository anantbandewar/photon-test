package com.photon.order_service;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class beans {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
