package es.iesrafaelalberti.boardgameApi.dto;

import es.iesrafaelalberti.boardgameApi.models.Comment;
import es.iesrafaelalberti.boardgameApi.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private List<CommentDTO> comments = new ArrayList<>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        for(Comment comment: user.getComment())
            comments.add(new CommentDTO(comment));
    }
}
