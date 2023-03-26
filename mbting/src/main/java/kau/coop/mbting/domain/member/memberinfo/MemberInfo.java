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

    public MemberInfo(String nickname, Gender gender, Long age, Academy academy, Mbti mbti, Address address, Hobby hobby) {
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
        this.academy = academy;
        this.mbti = mbti;
        this.address = address;
        this.hobby = hobby;
    }
}
