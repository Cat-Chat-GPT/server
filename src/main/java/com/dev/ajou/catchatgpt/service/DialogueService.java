package com.dev.ajou.catchatgpt.service;

import com.dev.ajou.catchatgpt.repository.DialogueRepository;

public class DialogueService {
    private DialogueRepository dialogueRepository;

    public DialogueService(DialogueRepository dialogueRepository) {
        this.dialogueRepository = dialogueRepository;
    }
}
