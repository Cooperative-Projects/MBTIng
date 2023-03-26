package kau.coop.mbting.repository.member;

import kau.coop.mbting.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Member update(Member member);

    Optional<Member> findById(Long identifyId);
    Optional<Member> findById(String userId);

    Optional<Member> findByNickname(String nickname);

    List<Member> findAll();

    void delete(Long memberId);

    void clear();
}
