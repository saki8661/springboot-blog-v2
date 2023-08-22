package shop.mtcoding.blogv2.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blogv2.board.Board;
import shop.mtcoding.blogv2.reply.ReplyRequest.SaveDTO;
import shop.mtcoding.blogv2.user.User;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    public void 댓글삭제(Integer id) {
        try {
            replyRepository.deleteById(id);
        } catch (Exception e) {
           throw new RuntimeException(id+"를 찾을 수 없어요");
        }
    }

    public void 댓글쓰기(SaveDTO saveDTO, Integer id) {
    }

    // @Transactional
    // public void 댓글쓰기(ReplyRequest.ReplyDTO replyDTO, Integer sessionUserId) {
    //    Reply reply = Reply.builder()
    //         .comment(replyDTO.getComment())
    //         .board(Board.builder().id(replyDTO.getBoardId()).build())
    //         .user(User.builder().id(sessionUserId).build())
    //         .build();
    //    replyRepository.save(reply);
    // }

}
