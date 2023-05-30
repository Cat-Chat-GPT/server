package com.dev.ajou.catchatgpt.service;

import com.dev.ajou.catchatgpt.domain.Dialogue;
import com.dev.ajou.catchatgpt.repository.DialogueRepository;
import com.dev.ajou.catchatgpt.service.dto.request.Message;

public class DialogueService {
    private DialogueRepository dialogueRepository;
    private GPTService gptService;

    public DialogueService(DialogueRepository dialogueRepository) {
        this.dialogueRepository = dialogueRepository;
    }

    public Dialogue chatWithAnimal(Dialogue dialogue, Long id) {
        dialogueRepository.save(dialogue, id);
        return dialogue;
    }
}
