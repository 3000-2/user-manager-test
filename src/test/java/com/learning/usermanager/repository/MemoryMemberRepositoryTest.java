package com.learning.usermanager.repository;

import com.learning.usermanager.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("park");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        System.out.println("result = " + (result == member));

//      Assertions.assertEquals(member, result); // from junit.jupiter
        assertThat(member).isEqualTo(result); // from assertj
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("park1");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("park2");
        repository.save(member2);

        Member result = repository.findByName("park1").get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("park1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("park2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
