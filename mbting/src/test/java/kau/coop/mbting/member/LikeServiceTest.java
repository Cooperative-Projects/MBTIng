package kau.coop.mbting.member;


import kau.coop.mbting.AutoAppConfig;
import kau.coop.mbting.domain.accept.AcceptPolicy;
import kau.coop.mbting.domain.accept.CreateChatRoomAcceptPolicy;
import kau.coop.mbting.repository.like.LikeBoxRepository;
import kau.coop.mbting.repository.like.MemoryLikeBoxRepository;
import kau.coop.mbting.service.like.LikeService;
import kau.coop.mbting.service.like.LikeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LikeServiceTest {

    LikeBoxRepository likeBoxRepository = new MemoryLikeBoxRepository();
    AcceptPolicy acceptPolicy = new CreateChatRoomAcceptPolicy();
    LikeService likeService = new LikeServiceImpl(likeBoxRepository, acceptPolicy);

    @Test
    void testService(){
        likeService.sendLike(1L,2L);
        likeService.sendLike(1L,5L);
        System.out.println("sender list = " + likeService.checkLike(1L));
        Assertions.assertThat(likeService.checkLike(1L)).isEqualTo(new ArrayList<>(){
            {
                add(2L);
                add(5L);
            }
        });
    }

    @Test
    void testAcceptPolicy(){
        likeService.acceptLike(1L, 2L);
    }

}
