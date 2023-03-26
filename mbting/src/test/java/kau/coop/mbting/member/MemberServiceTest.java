package kau.coop.mbting.member;

import kau.coop.mbting.domain.member.*;
import kau.coop.mbting.domain.member.memberinfo.*;
import kau.coop.mbting.repository.member.MemberRepository;
import kau.coop.mbting.repository.member.MemoryMemberRepository;
import kau.coop.mbting.service.member.MemberService;
import kau.coop.mbting.service.member.MemberServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

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
    @DisplayName("회원 가입")
    void register() {

        try {
            //given
            Member member = memberService.register("testId", "testPasswd", "testPasswd");

            //when
            Member member1 = memberService.findOne(member.getIdentityId()).get();

            //then
            assertThat(member1.getId()).isEqualTo("testId");
            assertThat(member1.getPasswd()).isEqualTo("testPasswd");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("중복 계정 검사")
    void validateAccount() throws Exception {
        //given
        Member member1;
        Member member2;
        member1 = memberService.register("testId", "testPasswd123", "testPasswd123");

        //when
        try {
            memberService.register("testId", "testPasswd", "testPasswd");
            fail("중복 계정 검사를 실패");
        }catch (Exception e) {
            assertThat(e).isInstanceOf(Exception.class);
        }
    }

    @Test
    @DisplayName("회원 삭제")
    void delete() throws Exception {
        //given
        Member member;
        member = memberService.register("testId", "testPasswd", "testPasswd");
        assertThat(member).isEqualTo(memberService.findOne(member.getIdentityId()).get());

        //when
        memberService.quit(member.getIdentityId());

        //then
        assertThat(memberService.findOne(member.getIdentityId())
                .isEmpty())
                .isTrue();
    }

    @Test
    @DisplayName("회원 정보 업데이트")
    void update() throws Exception {
        //given
        Member member;
        MemberInfo memberInfo = new MemberInfo("testNick", Gender.MALE, 24L, Academy.한국항공대학교, Mbti.INTJ, Address.강서, Hobby.게임);
        member = memberService.register("testId", "testPasswd", "testPasswd");

        //when
        memberService.updateMemberInfo(member.getIdentityId(), memberInfo);

        //then
        assertThat(memberService.findOne(member.getIdentityId()).get().getMemberInfo()).isEqualTo(memberInfo);

    }

    @Test
    @DisplayName("passwd 변경")
    void changePasswd() throws Exception {
        //given
        Member member = memberService.register("testId", "testPasswd", "testPasswd");

        //when
        memberService.changePasswd(member.getId(), member.getPasswd(), "newPasswd");

        //then
        assertThat(member.getPasswd()).isEqualTo("newPasswd");
    }
}
