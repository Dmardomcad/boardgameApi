package es.iesrafaelalberti.boardgameApi.dto;

import es.iesrafaelalberti.boardgameApi.models.Boardgame;
import es.iesrafaelalberti.boardgameApi.models.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BoardgameDTO {
    private Long id;
    private String name;
    private String description;
    private String detailImage;
    private int duration;
    private String difficulty;
    private String category;
    private List<CommentDTO> comments = new ArrayList<>();

    public BoardgameDTO(Boardgame boardgame){
        this.id = boardgame.getId();
        this.name = boardgame.getName();
        this.description = boardgame.getDescription();
        this.detailImage = boardgame.getDetailImage();
        this.duration = boardgame.getDuration();
        this.difficulty = boardgame.getDifficulty();
        this.category = boardgame.getCategory();
        for (Comment comment: boardgame.getComment())
            comments.add(new CommentDTO(comment));
    }

}
