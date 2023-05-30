package com.dev.ajou.catchatgpt;

import com.dev.ajou.catchatgpt.repository.MemoryDialogueRepository;
import com.dev.ajou.catchatgpt.repository.DialogueRepository;
import com.dev.ajou.catchatgpt.service.DialogueService;
import com.dev.ajou.catchatgpt.service.GPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Autowired
    public SpringConfig() { }

    @Bean
    public DialogueService dialogueService() { return new DialogueService(dialogueRepository()); }

    @Bean
    public GPTService gptService() {
        return new GPTService(
                "https://api.openai.com/v1/chat/completions",
                "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"
        );
    }

    @Bean
    public DialogueRepository dialogueRepository() { return new MemoryDialogueRepository();}
}
