package kau.coop.mbting.service.member;

import kau.coop.mbting.domain.member.Member;
import kau.coop.mbting.repository.member.MemberRepository;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    /**
     * 회원가입
     * @param member
     */
    void join(Member member);

    /**
     * 회원 하나 조회
     * @param memberId 회원 아이디
     * @return
     */
    Optional<Member> findOne(Long memberId);

    /**
     * 회원 전체 조회
     * @return
     */
    List<Member> findAll();

    /**
     * 회원 탈퇴
     * @param memberId
     */
    void quit(Long memberId);


}
