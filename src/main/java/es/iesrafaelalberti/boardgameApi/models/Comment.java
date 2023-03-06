package es.iesrafaelalberti.boardgameApi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn()
    private Boardgame boardgame;

    public Comment(){

    }

    public Comment(String content, Boardgame boardgame) {
        this.content = content;
        this.boardgame = boardgame;
    }
}
