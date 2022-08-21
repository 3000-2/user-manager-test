package com.learning.usermanager;

import com.learning.usermanager.repository.JpaMemberRepository;
import com.learning.usermanager.repository.MemberRepository;
import com.learning.usermanager.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * component scan 방식이 아닌 직접 bean 등록하기
 */


@Configuration
public class SpringConfig {

    //    private final DataSource dataSource;
    private final EntityManager em;

//    private final MemberRepository memberRepository;
//
//    @Autowired
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
