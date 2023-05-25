package com.dev.ajou.catchatgpt.repository;

import com.dev.ajou.catchatgpt.domain.Dialogue;

import java.util.List;
import java.util.Optional;

public interface DialogueRepository {
    Dialogue save(Dialogue dialogue, Long id);

    List<Dialogue> findById(Long id);
}
