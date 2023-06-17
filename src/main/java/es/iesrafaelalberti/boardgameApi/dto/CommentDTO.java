package es.iesrafaelalberti.boardgameApi.dto;


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
    private String content;
    private String username;
    public CommentDTO(Long id, Long boardgameId, String content, String username) {
        this.id = id;
        this.boardgameId = boardgameId;
        this.content = content;
        this.username = username;
    }
}
