package com.dev.ajou.catchatgpt.service.dto.request;

public class DialogueRequest {
    String text;
    Long id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
