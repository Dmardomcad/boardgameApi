package es.iesrafaelalberti.boardgameApi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<CommentDTO> comments;

    public BoardgameDTO(Long id, String name, String description, String detailImage, int duration, String difficulty, String category,List<CommentDTO> comments){
        this.id = id;
        this.name = name;
        this.description = description;
        this.detailImage = detailImage;
        this.duration = duration;
        this.difficulty = difficulty;
        this.category = category;
        this.comments = comments;
    }

}
