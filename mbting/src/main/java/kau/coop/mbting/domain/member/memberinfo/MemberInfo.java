package kau.coop.mbting.domain.member.memberinfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberInfo {
    private String nickname;
    private Gender gender;
    private Long age;
    private Academy academy;
    private Mbti mbti;
    private Address address;
    private Hobby hobby;
}
