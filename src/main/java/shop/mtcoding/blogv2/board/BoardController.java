package shop.mtcoding.blogv2.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.mtcoding.blogv2.user.User;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    // localhost:8080?page=1&keyword=바나나
    @GetMapping("/")
    public String 봉준이(@RequestParam(defaultValue = "0") Integer page) {
        boardService.게시글목록보기();
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    // 1. 데이터 받기 (V)
    // 2. 인증체크 (:TODO)
    // 3. 유효성 검사 (:TODO)
    // 4. 핵심로직 호출(서비스)
    // 5. view or data 응답
    @PostMapping("/board/save")
    public String save(BoardRequest.SaveDTO saveDTO) {
        boardService.글쓰기(saveDTO, 1);
        return "redirect:/";
    }
}