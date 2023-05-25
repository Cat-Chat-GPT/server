package com.dev.ajou.catchatgpt.repository;

import com.dev.ajou.catchatgpt.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findByName(String name);

    Optional<Member> findById(Long id);

    List<Member> findAll();
}
