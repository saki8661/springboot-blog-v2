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

    @Transactional
    public void 댓글쓰기(SaveDTO saveDTO, Integer sessionId) {
        // insert into reply_tb(comment, board_id, user_id) values(?, ?, ?)

        // 1. board id가 존재하는지 유무
        Board board = Board.builder().id(saveDTO.getBoardId()).build();
        User user = User.builder().id(sessionId).build();

        Reply reply = Reply.builder()
        .comment(saveDTO.getComment())
        .board(board)
        .user(user)
        .build();
        replyRepository.save(reply); // entity : Reply 객체

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
