package jproject.my_board.service;

import jproject.my_board.domain.Reply;
import jproject.my_board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    @Transactional
    public void insertReply(Reply reply){
        replyRepository.add(reply);
    }

}
