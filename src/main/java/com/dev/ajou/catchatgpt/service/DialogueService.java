package com.dev.ajou.catchatgpt.service;

import com.dev.ajou.catchatgpt.domain.Dialogue;
import com.dev.ajou.catchatgpt.repository.DialogueRepository;
import com.dev.ajou.catchatgpt.service.dto.request.Message;

import java.util.List;

public class DialogueService {
    private DialogueRepository dialogueRepository;
    private GPTService gptService;

    public DialogueService(DialogueRepository dialogueRepository, GPTService gptService) {
        this.dialogueRepository = dialogueRepository;
        this.gptService = gptService;
    }

    public Dialogue chatWithAnimal(Dialogue dialogue, Long id) {


//        Message message = new Message();
//        message.setRole("user");
//        message.setContent(request.getText());
//        String answer = gptService.callGPT(message);

        List<Dialogue> dialogueList = dialogueRepository.findById(id);


//        all.stream().skip(Math.max(0, all.size() - n)).forEach(doSomething);

        dialogueRepository.save(dialogue, id);
        return dialogue;
    }
}
