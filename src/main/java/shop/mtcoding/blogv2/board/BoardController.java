package shop.mtcoding.blogv2.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blogv2.user.User;

@Controller
public class BoardController {

    private BoardRepository boardRepository;

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    // 1. 데이터 받기 (OK)
    // 2. 인증체크 (:TODO)
    // 3. 유효성 검사 (:TODO)
    // 4. 핵심로직 호출(서비스-트랜잭션관리)
    // 5. view or data 응답
    @PostMapping("board/save")
    public String save(BoardRequest.SaveDTO saveDTO) {
        Board board = Board.builder()
                .title(saveDTO.getTitle())
                .content(saveDTO.getContent())
                .user(User.builder().id(1).build())
                .build();

        boardRepository.save(board);

        return "redirect:/";
    }
}
