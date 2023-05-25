package com.dev.ajou.catchatgpt.serviceTests;


import com.dev.ajou.catchatgpt.domain.Dialogue;
import com.dev.ajou.catchatgpt.repository.MemoryDialogueRepository;
import com.dev.ajou.catchatgpt.service.DialogueService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DialogueServiceTest {
    DialogueService service;
    MemoryDialogueRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository = new MemoryDialogueRepository();
        service = new DialogueService(repository);
    }
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void chatWithAnimal() {
        // given
        Dialogue dialogue1 = new Dialogue();
        dialogue1.setText("Hello");

        Dialogue dialogue2 = new Dialogue();
        dialogue2.setText("My name is Hose");

        Long id = Long.valueOf(1);


        // when
        service.chatWithAnimal(dialogue1, id);
        List<Dialogue> result1 = repository.findById(id);

        // then
        assertThat(result1.get(0).getText()).isEqualTo("Hello");
        assertThat(result1.get(0).getOwnedById()).isEqualTo(id);

        // when
        service.chatWithAnimal(dialogue2, id);
        List<Dialogue> result2 = repository.findById(id);

        assertThat(result2.get(1).getText()).isEqualTo("My name is Hose");
        assertThat(result2.get(1).getOwnedById()).isEqualTo(id);

    }


}
