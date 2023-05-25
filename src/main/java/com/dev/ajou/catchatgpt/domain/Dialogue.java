package com.dev.ajou.catchatgpt.domain;

public class Dialogue {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getOwnedById() {
        return ownedById;
    }

    public void setOwnedById(Long ownedById) {
        this.ownedById = ownedById;
    }

    private String text;
    private Long ownedById;

}
