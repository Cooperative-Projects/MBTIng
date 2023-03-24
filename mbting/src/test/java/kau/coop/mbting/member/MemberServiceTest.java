package kau.coop.mbting.member;

import kau.coop.mbting.domain.member.*;
import kau.coop.mbting.repository.member.MemberRepository;
import kau.coop.mbting.repository.member.MemoryMemberRepository;
import kau.coop.mbting.service.member.MemberService;
import kau.coop.mbting.service.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    MemberRepository memberRepository;
    MemberService memberService;
    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberServiceImpl(memberRepository);
    }

    @AfterEach
    void clear() {
        memberRepository.clear();
    }

    @Test
    @DisplayName("회원가입")
    void join() {
        Member member = new Member("hhtboy", Gender.MALE, 24L, Academy.한국항공대학교, Mbti.INTJ, Address.강서, Hobby.게임);

        memberService.join(member);

        Optional<Member> member2 = memberService.findOne(member.getId());

        assertThat(member).isEqualTo(member2.get());
    }

    @Test
    @DisplayName("회원 삭제")
    void delete() {
        Member member = new Member("hhtboy", Gender.MALE, 24L, Academy.한국항공대학교, Mbti.INTJ, Address.강서, Hobby.게임);

        memberService.join(member);
        assertThat(member).isEqualTo(memberService.findOne(member.getId()).get());

        memberService.quit(member.getId());
        assertThat(memberService.findOne(member.getId())
                .isEmpty())
                .isTrue();
    }

}
