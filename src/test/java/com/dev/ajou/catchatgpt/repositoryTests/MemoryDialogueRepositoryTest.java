package com.dev.ajou.catchatgpt.repositoryTests;

import com.dev.ajou.catchatgpt.domain.Dialogue;
import com.dev.ajou.catchatgpt.repository.MemoryDialogueRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MemoryDialogueRepositoryTest {

    MemoryDialogueRepository memoryDialogueRepository = new MemoryDialogueRepository();

    @AfterEach
    public void afterEach() {
        memoryDialogueRepository.clearStore();
    }
    @Test
    public void save() {
        //given

        Dialogue dialogue1 = new Dialogue();
        Long id = Long.valueOf(1);
        dialogue1.setOwnedById(id);
        dialogue1.setText("hello");

        //when
        memoryDialogueRepository.save(dialogue1, id);
        //then
        List<Dialogue> results = memoryDialogueRepository.findById(id);

        assertThat(results.get(0).getText()).isEqualTo("hello");
        assertThat(results.get(0).getOwnedById()).isEqualTo(Long.valueOf(1));
    }

    @Test
    public void findById() {
        // given
        Dialogue dialogue1 = new Dialogue();
        Long id = Long.valueOf(1);
        dialogue1.setOwnedById(id);
        dialogue1.setText("hello");

        Dialogue dialogue2 = new Dialogue();
        dialogue2.setOwnedById(id);
        dialogue2.setText("hello2");

        Dialogue dialogue3 = new Dialogue();
        dialogue3.setOwnedById(id);
        dialogue3.setText("hello3");

        memoryDialogueRepository.save(dialogue1, id);
        memoryDialogueRepository.save(dialogue2, id);
        memoryDialogueRepository.save(dialogue3, id);

        //when

        List<Dialogue> results = memoryDialogueRepository.findById(id);

        // then

        assertThat(results.size()).isEqualTo(3);
        assertThat(results.get(0).getText()).isEqualTo("hello");
        assertThat(results.get(1).getText()).isEqualTo("hello2");
        assertThat(results.get(2).getText()).isEqualTo("hello3");



    }
}