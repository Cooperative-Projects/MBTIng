package kau.coop.mbting.domain.member;

import lombok.Getter;

// 범위 지정이 가능한 mbti, gender, address 등은 최대한 enum class를 이용하였습니다.
@Getter
public class Member {

    /**
     * 고유 ID로 회원 조회할 때 사용합니다.
     */
    private Long id;
    private String nickname;
    private Gender gender;
    private Long age;
    private Academy academy;
    private Mbti mbti;
    private Address address;
    private Hobby hobby;



    public Member(String nickname, Gender gender, Long age, Academy academy, Mbti mbti, Address address, Hobby hobby) {
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
        this.academy = academy;
        this.mbti = mbti;
        this.address = address;
        this.hobby = hobby;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
