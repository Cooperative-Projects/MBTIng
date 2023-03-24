package kau.coop.mbting.service.member;

import kau.coop.mbting.domain.member.Member;
import kau.coop.mbting.repository.member.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {

    }

    @Override
    public Optional<Member> findOne(Long memberId) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public void quit(Member member) {

    }
}
