package com.dev.ajou.catchatgpt.controller;

import com.dev.ajou.catchatgpt.service.DialogueService;
import org.springframework.stereotype.Controller;

@Controller
public class DialogueController {
    private final DialogueService dialogueService;

    public DialogueController(DialogueService dialogueService) {
        this.dialogueService = dialogueService;
    }



}
