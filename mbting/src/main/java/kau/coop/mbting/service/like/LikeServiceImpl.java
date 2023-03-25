package kau.coop.mbting.service.like;

import kau.coop.mbting.domain.accept.AcceptPolicy;
import kau.coop.mbting.repository.like.LikeBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LikeServiceImpl implements LikeService{

    private final LikeBoxRepository likeBoxRepository;
    private final AcceptPolicy acceptPolicy;

    @Autowired
    public LikeServiceImpl(LikeBoxRepository likeBoxRepository, AcceptPolicy acceptPolicy) {
        this.likeBoxRepository = likeBoxRepository;
        this.acceptPolicy = acceptPolicy;
    }

    @Override
    public void sendLike(Long receiver, Long sender) {
        likeBoxRepository.sendLike(receiver, sender);
    }

    @Override
    public List<Long> checkLike(Long id) {
        return likeBoxRepository.findAll(id);
    }

    @Override
    public void acceptLike(Long receiver, Long sender) {
        acceptPolicy.acceptEvent(receiver, sender);
    }
}
