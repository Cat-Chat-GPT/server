package com.dev.ajou.catchatgpt.controller;

import com.dev.ajou.catchatgpt.service.DialogueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DialogueController {
    private final DialogueService dialogueService;

    public DialogueController(DialogueService dialogueService) {
        this.dialogueService = dialogueService;
    }


    @GetMapping("/test")
    public String testMethod() {

        return "ddd";
    }

}
