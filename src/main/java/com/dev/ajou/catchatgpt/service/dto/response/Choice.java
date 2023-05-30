package com.dev.ajou.catchatgpt.service.dto.response;

import com.dev.ajou.catchatgpt.service.dto.request.Message;

public class Choice {
    private int index;
    private Message message;
    private String finish_reason;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }
}
