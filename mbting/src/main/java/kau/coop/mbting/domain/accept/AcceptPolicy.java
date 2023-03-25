package kau.coop.mbting.domain.accept;

public interface AcceptPolicy {

    /**
     *  좋아요 수락시 이벤트
     */
    void acceptEvent(Long receiver, Long sender);

}
