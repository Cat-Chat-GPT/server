package com.dev.ajou.catchatgpt.repository;

import com.dev.ajou.catchatgpt.domain.Dialogue;
import com.dev.ajou.catchatgpt.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryDialogueRepository implements DialogueRepository {

    private static Map<Long, List<Dialogue>> store = new HashMap<>();
    @Override
    public Dialogue save(Dialogue dialogue, Long id) {
        dialogue.setOwnedById(id);

        List<Dialogue> empty = new ArrayList<>();
        List<Dialogue> dialogues = store.getOrDefault(id, empty);
        dialogues.add(dialogue);

        store.put(id, dialogues);
        return dialogue;
    }

    @Override
    public List<Dialogue> findById(Long id) {
        return store.get(id);
    }

    public void clearStore() {
        store.clear();
    }
}
