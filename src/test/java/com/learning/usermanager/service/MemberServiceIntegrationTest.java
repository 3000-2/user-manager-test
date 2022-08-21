package com.learning.usermanager.service;

import com.learning.usermanager.domain.Member;
import com.learning.usermanager.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

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

    }


}