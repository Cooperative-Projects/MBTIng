package kau.coop.mbting.service.like;

import java.util.List;

public interface LikeService {

    /**
     * sender가 receiver에게
     * 좋아요 전송
     */
    void sendLike(Long receiver, Long sender);


    /**
     * 해당 id가 받은 좋아요
     * 리스트 반환
     * @param id
     */
    List<Long> checkLike(Long id);

    /**
     * 해당 sender로 부터 받은 좋아요
     * 수락시 이벤트 처리하기
     */
    void acceptLike(Long receiver, Long sender);

}
