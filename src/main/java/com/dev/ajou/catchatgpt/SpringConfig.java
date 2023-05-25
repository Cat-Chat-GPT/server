package com.dev.ajou.catchatgpt;

import com.dev.ajou.catchatgpt.repository.DialogueMemoryRepository;
import com.dev.ajou.catchatgpt.repository.DialogueRepository;
import com.dev.ajou.catchatgpt.service.DialogueService;
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
    public DialogueRepository dialogueRepository() { return new DialogueMemoryRepository();}
}
