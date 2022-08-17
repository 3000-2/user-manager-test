package com.learning.usermanager;

import com.learning.usermanager.repository.MemberRepository;
import com.learning.usermanager.repository.MemoryMemberRepository;
import com.learning.usermanager.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * component scan 방식이 아닌 직접 bean 등록하기
 */


@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
