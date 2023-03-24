package kau.coop.mbting.domain.member;

// 범위 지정이 가능한 mbti, gender, address 등은 최대한 enum class를 이용하였습니다.
public class Member {

    /**
     * 고유 ID로 회원 조회할 때 사용합니다.
     */
    public Long id;
    public String nickname;
    public Gender gender;
    public Long age;
    public Academy academy;
    public Mbti mbti;
    public Address address;

    public Hobby hobby;

    public Member(Long id, String nickname, Gender gender, Long age, Academy academy, Mbti mbti, Address address, Hobby hobby) {
        this.id = id;
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
        this.academy = academy;
        this.mbti = mbti;
        this.address = address;
        this.hobby = hobby;
    }
}
