package com.learning.usermanager.service;

import com.learning.usermanager.domain.Member;
import com.learning.usermanager.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("park");

        Long savedId = memberService.join(member);

        Member result = memberService.findOne(savedId).get();
        Assertions.assertEquals(member.getName(), result.getName());
    }

    @Test
    void 중복_회원_예외() {
        Member member = new Member();
        member.setName("park");

        Member member2 = new Member();
        member2.setName("park");

        memberService.join(member);
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });

        Assertions.assertEquals("이미 존재하는 회원입니다.", e.getMessage());
/*
        service.join(member);
        try {
            service.join(member2);
            fail("엑셉션을 던져야 합니다.");
        } catch (IllegalStateException e) {
            assertThat("이미 존재하는 회원입니다.").isEqualTo(e.getMessage());
        }
*/
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}