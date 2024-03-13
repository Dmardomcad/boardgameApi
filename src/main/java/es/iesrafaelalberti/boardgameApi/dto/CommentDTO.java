package es.iesrafaelalberti.boardgameApi.dto;


import es.iesrafaelalberti.boardgameApi.models.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
public class CommentDTO implements Serializable {
    private Long id;
    private Long boardgameId;
    private String name;
    private String content;
    private String username;
    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.boardgameId = comment.getBoardgame().getId();
        this.name = comment.getBoardgame().getName();
        this.content = comment.getContent();
        this.username = comment.getUser().getUsername();
    }
}
