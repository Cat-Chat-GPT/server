package com.dev.ajou.catchatgpt.controller;

import com.dev.ajou.catchatgpt.common.ApiResponse;
import com.dev.ajou.catchatgpt.domain.Dialogue;
import com.dev.ajou.catchatgpt.service.DialogueService;
import com.dev.ajou.catchatgpt.service.GPTService;
import com.dev.ajou.catchatgpt.service.dto.request.DialogueRequest;
import com.dev.ajou.catchatgpt.service.dto.request.Message;
import com.dev.ajou.catchatgpt.service.dto.response.DialogueResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DialogueController {
    private final DialogueService dialogueService;

    public DialogueController(DialogueService dialogueService) {

        this.dialogueService = dialogueService;
    }

    @PostMapping("/chat")
    public ApiResponse<DialogueResponse> chatWithAnimal(@RequestBody DialogueRequest request) {


//        Message message = new Message();
//        message.setRole("user");
//        message.setContent(request.getText());
//        String answer = gptService.callGPT(message);

        Dialogue dialogue = new Dialogue();
        dialogue.setText(request.getText());
        dialogueService.chatWithAnimal(dialogue, request.getId());

        DialogueResponse response = new DialogueResponse();

//        response.setAnswer(answer);




        return ApiResponse.success(response);
    }

}
