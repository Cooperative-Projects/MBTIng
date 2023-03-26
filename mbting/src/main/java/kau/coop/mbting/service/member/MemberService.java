package kau.coop.mbting.service.member;

import kau.coop.mbting.domain.member.Member;
import kau.coop.mbting.domain.member.memberinfo.MemberInfo;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    /**
     * 회원가입
     * @param passwd 비밀번호
     * @param passwdVerify 비밀번호 확인
     */
     Member register(String id, String passwd, String passwdVerify) throws Exception;


    /**
     * 비밀번호 변경
     * @throws Exception
     */
    void changePasswd(String id, String passwd, String newPasswd) throws Exception;

    /**
     * 회원 정보 저장 & 업데이트
     */
    void updateMemberInfo(Long identifyId, MemberInfo memberInfo);

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
