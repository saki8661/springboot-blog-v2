package shop.mtcoding.blogv2.reply;

import lombok.Getter;
import lombok.Setter;

public class ReplyRequest {

    @Getter
    @Setter
    public static class SaveDTO {
        private Integer boardId;
        private String comment;
    }

    // @Getter
    // @Setter
    // public static class ReplyDTO {
    //     private Integer boardId;
    //     private String comment;
    // }
    
}
