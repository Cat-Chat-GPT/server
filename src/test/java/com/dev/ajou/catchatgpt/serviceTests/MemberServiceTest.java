package com.dev.ajou.catchatgpt.serviceTests;

import com.dev.ajou.catchatgpt.domain.Member;
import com.dev.ajou.catchatgpt.repository.MemberRepository;
import com.dev.ajou.catchatgpt.repository.MemoryMemberRepository;
import com.dev.ajou.catchatgpt.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {
    MemberService service;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository = new MemoryMemberRepository();
        service = new MemberService(repository);
    }
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void 회원가입() throws Exception {
        // given

        Member member = new Member();
        member.setName("hose");

        //when
        Long saveId = service.join(member);

        // then

        Member findMember = repository.findById(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void 중복_회원_가입_오류() throws Exception {

        // given
        Member member1 = new Member();
        member1.setName("Hose");

        Member member2 = new Member();
        member2.setName("Hose");


        //when

        service.join(member1);

        IllegalStateException e = assertThrows(
                IllegalStateException.class,
                () ->  service.join(member2)
        );

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
