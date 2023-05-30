package com.dev.ajou.catchatgpt.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Consumer;

public class WebClientUtil {

    public static WebClient create(String url, String apiKey) {
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeaders(httpHeadersConsumer(apiKey))
                .build();
    }

    private static Consumer<HttpHeaders> httpHeadersConsumer(String apiKey){
        return httpHeaders -> {
            httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        };
    }
}
