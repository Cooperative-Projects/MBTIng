package kau.coop.mbting.service.member;

import kau.coop.mbting.domain.member.Member;
import kau.coop.mbting.domain.member.memberinfo.MemberInfo;
import kau.coop.mbting.repository.member.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member register(String id, String passwd, String passwdVerify) throws Exception {
        if (memberRepository.findById(id).isPresent()) {
            throw new Exception("이미 존재하는 ID 입니다.");
        }
        if (!passwd.equals(passwdVerify)) {
            throw new Exception("입력한 두 비밀번호가 일치하지 않습니다");
        }
        Member member = new Member(id, passwd);
        memberRepository.save(member);
        return member;
    }

    @Override
    public void changePasswd(String id, String passwd, String newPasswd) throws Exception {
        Member member = verifyAccount(id, passwd);
        member.setPasswd(newPasswd);
        memberRepository.update(member);
    }

    @Override
    public void updateMemberInfo(Long identifyId, MemberInfo memberInfo) {
        memberRepository.findById(identifyId)
                .ifPresent(member -> {
                    member.setMemberInfo(memberInfo);
                    memberRepository.update(member);
                });
    }

    @Override
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public void quit(Long memberId) {
        memberRepository.delete(memberId);
    }

    private Member verifyAccount(String id, String passwd) throws NoSuchElementException {
        Member member = memberRepository.findById(id).orElseThrow();
        if (member.getPasswd().equals(passwd)) {
            return member;
        } else {
            throw new NoSuchElementException("해당 계정 정보가 없습니다.");
        }
    }
}
