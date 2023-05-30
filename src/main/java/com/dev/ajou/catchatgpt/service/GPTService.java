package com.dev.ajou.catchatgpt.service;

import com.dev.ajou.catchatgpt.service.dto.request.GPTRequest;
import com.dev.ajou.catchatgpt.service.dto.request.Message;
import com.dev.ajou.catchatgpt.service.dto.response.GPTResponse;
import com.dev.ajou.catchatgpt.util.WebClientUtil;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GPTService {
    String apiUrl;
    String apiKey;

    WebClient client;

    public GPTService(String apiUrl, String apiKey) {
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
        this.client = WebClientUtil.create(apiUrl, apiKey);

    }

    public String callGPT(Message message) {
        return client.post()
                .bodyValue(makeGPTRequest(message))
                .retrieve()
                .bodyToMono(GPTResponse.class)
                .blockOptional()
                .get().getChoices().get(0).getMessage().getContent();
    }

    private GPTRequest makeGPTRequest(Message message) {

        List<Message> messages = new ArrayList<>();
        messages.add(message);
        GPTRequest request = new GPTRequest();
        request.setModel("gpt-3.5-turbo");
        request.setMessages(messages);

        return request;
    }

}
