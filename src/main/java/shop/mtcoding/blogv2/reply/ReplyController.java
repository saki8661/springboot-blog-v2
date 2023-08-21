package shop.mtcoding.blogv2.reply;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.blogv2._core.util.Script;
import shop.mtcoding.blogv2.user.User;

@Controller
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @Autowired
    private HttpSession session;

    @PostMapping("/reply/{id}/delete")
    public @ResponseBody String delete(@PathVariable Integer id, Integer boardId) {
        replyService.댓글삭제(id);
        return Script.href("/board/"+boardId);
    }



    @PostMapping("/reply/save")
    public String save(ReplyRequest.ReplyDTO replyDTO, Integer boardId) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        replyService.댓글쓰기(replyDTO, sessionUser.getId());
        return "redirect:/board/" + boardId;
    }


}
