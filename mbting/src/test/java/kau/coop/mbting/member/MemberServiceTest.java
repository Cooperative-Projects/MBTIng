package kau.coop.mbting.member;

import kau.coop.mbting.domain.member.*;
import kau.coop.mbting.repository.member.MemberRepository;
import kau.coop.mbting.repository.member.MemoryMemberRepository;
import kau.coop.mbting.service.member.MemberService;
import kau.coop.mbting.service.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class MemberServiceTest {

    MemberRepository memberRepository;
    MemberService memberService;

//    @Test
//    @DisplayName("회원가입")
//    void join() {
//        Member member = new Member(100L, "hhtboy", Gender.MALE, 24L, Academy.한국항공대학교, Mbti.INTJ, Address.강서, Hobby.게임);
//
//        memberService.join(member);
//
//        Optional<Member> member2 = memberService.findOne(member.id);
//    }

}
