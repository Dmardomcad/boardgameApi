package es.iesrafaelalberti.boardgameApi.dto;

import es.iesrafaelalberti.boardgameApi.models.Boardgame;
import es.iesrafaelalberti.boardgameApi.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CommentCreateDTO implements Serializable {
    private Long id;
    private User user;
    private Boardgame boardgame;
    private String content;

    public CommentCreateDTO(Long id, User user, Boardgame boardgame,String content) {
        this.id = id;
        this.user= user;
        this.boardgame = boardgame;
        this.content = content;
    }
}
