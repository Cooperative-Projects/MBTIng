package kau.coop.mbting.domain.member;

import kau.coop.mbting.domain.member.memberinfo.MemberInfo;
import lombok.Getter;

@Getter
public class Member {

    /**
     * 고유 ID로 회원 조회할 때 사용합니다.
     */
    private Long identityId;
    private String id;
    private String passwd;
    private MemberInfo memberInfo;

    public Member(String id, String passwd) {
        this.id = id;
        this.passwd = passwd;
    }

    public void setIdentityId(Long identityId) {
        this.identityId = identityId;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }
}
