package com.dev.ajou.catchatgpt.repository;

import com.dev.ajou.catchatgpt.domain.Dialogue;
import com.dev.ajou.catchatgpt.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryDialogueRepository implements DialogueRepository {

    private static Map<Long, Dialogue> store = new HashMap<>();
    @Override
    public Dialogue save(Dialogue dialogue, Long id) {
        dialogue.setOwnedById(id);
        store.put(id, dialogue);
        return dialogue;
    }

    @Override
    public List<Dialogue> findById(Long id) {
        return store.values().stream()
                .filter(dialogue -> dialogue.getOwnedById().equals(id))
                .toList();
    }
}
