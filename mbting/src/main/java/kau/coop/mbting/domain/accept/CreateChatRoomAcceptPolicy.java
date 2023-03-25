package kau.coop.mbting.domain.accept;

import org.springframework.stereotype.Component;

@Component
public class CreateChatRoomAcceptPolicy implements AcceptPolicy{

    @Override
    public void acceptEvent(Long receiver, Long sender) {
        createChatRoom(receiver, sender);
    }

    /**
     *  채팅룸 생성 메서드
     */
    private void createChatRoom(Long receiver, Long sender) {
        //해당 id의 사람과 채팅방 생성 logic
        System.out.println(receiver +" 와 " + sender +" 사이의 채팅방 생성 완료!");
    }
}
