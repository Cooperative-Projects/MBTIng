package kau.coop.mbting.repository.member;

import kau.coop.mbting.domain.member.Member;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long memberId) {
        return Optional.ofNullable(store.get(memberId));

    }

    @Override
    public Optional<Member> findByNickname(String nickname) {
         return store.values().stream()
                .filter( member -> member.getNickname().equals(nickname))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(Long memberId) {
        store.remove(memberId);
    }

    @Override
    public void clear() {
        store.clear();
    }
}
