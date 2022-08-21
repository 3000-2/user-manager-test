package com.learning.usermanager;

import com.learning.usermanager.repository.JdbcTemplateMemberRepository;
import com.learning.usermanager.repository.MemberRepository;
import com.learning.usermanager.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * component scan 방식이 아닌 직접 bean 등록하기
 */


@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
