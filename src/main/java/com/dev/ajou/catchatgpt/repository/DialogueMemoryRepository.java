package com.dev.ajou.catchatgpt.repository;

import com.dev.ajou.catchatgpt.domain.Dialogue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DialogueMemoryRepository implements DialogueRepository {

    private static Map<Long, Dialogue> store = new HashMap();

    @Override
    public Dialogue save(Dialogue dialogue) {
//        store.put()

        return null;
    }

    @Override
    public List<Dialogue> findAll() {
        return null;
    }
}
