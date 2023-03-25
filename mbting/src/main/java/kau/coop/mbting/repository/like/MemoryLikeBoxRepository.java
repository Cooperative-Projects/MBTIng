package kau.coop.mbting.repository.like;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Component
public class MemoryLikeBoxRepository implements LikeBoxRepository{

    MultiValueMap<Long, Long> mvMap = new LinkedMultiValueMap<>();

    @Override
    public void sendLike(Long receiver, Long sender) {
        mvMap.add(receiver, sender);
    }

    @Override
    public List<Long> findAll(Long id) {
        return mvMap.get(id);
    }
}
