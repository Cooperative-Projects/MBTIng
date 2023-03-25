package kau.coop.mbting.repository.like;

import java.util.List;

public interface LikeBoxRepository{

    /**
     * sender가 receiver에게
     * 좋아요 전송
     */
    void sendLike(Long receiver, Long sender);

    /**
     * 좋아요 보낸 모든 사람 리스트 반환
     * @return List<Long>
     */
    List<Long> findAll(Long id);

}
