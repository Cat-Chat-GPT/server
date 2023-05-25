package com.dev.ajou.catchatgpt.repositoryTests;

import com.dev.ajou.catchatgpt.domain.Member;
import com.dev.ajou.catchatgpt.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void save() {
        // given
        Member member = new Member();
        member.setName("Hose");

        // when
        repository.save(member);

        // then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);

    }

    @Test
    public void findByName() {

        // given
        Member member1 = new Member();
        member1.setName("Hose");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("KIM");
        repository.save(member2);

        // when
        Member result = repository.findByName("Hose").get();

        // Then
        assertThat(result).isEqualTo(member1);


    }

    @Test
    public void findAll() {
        // given
        Member member1 = new Member();
        member1.setName("Hose");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("KIM");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);


    }
}