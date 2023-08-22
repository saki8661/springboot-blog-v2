package shop.mtcoding.blogv2.reply;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.blogv2._core.error.ex.MyApiException;
import shop.mtcoding.blogv2._core.util.ApiUtil;
import shop.mtcoding.blogv2._core.util.Script;
import shop.mtcoding.blogv2.user.User;

@Controller
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @Autowired
    private HttpSession session;

    @PostMapping("api/reply/save")
    public @ResponseBody ApiUtil<String> save(@RequestBody ReplyRequest.SaveDTO saveDTO){
        // System.out.println("boardId : "+saveDTO.getBoardId());
        // System.out.println("comment : "+saveDTO.getComment());

        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser == null){
            //return new ApiUtil<String>(false, "인증이 되지 않았습니다");    
            throw new MyApiException("인증되지 않았습니다");
        }
        //replyService.댓글쓰기(saveDTO, sessionUser.getId());
        return new ApiUtil<String>(true, "댓글쓰기 성공");
    }

    @PostMapping("/reply/{id}/delete")
    public @ResponseBody String delete(@PathVariable Integer id, Integer boardId) {
        replyService.댓글삭제(id);
        return Script.href("/board/"+boardId);
    }



    // @PostMapping("/reply/save")
    // public String save(ReplyRequest.ReplyDTO replyDTO, Integer boardId) {
    //     User sessionUser = (User) session.getAttribute("sessionUser");
    //     replyService.댓글쓰기(replyDTO, sessionUser.getId());
    //     return "redirect:/board/" + boardId;
    // }


}
