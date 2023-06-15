package es.iesrafaelalberti.boardgameApi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity @Getter @Setter
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 1500)
    private String content;

    @JsonBackReference(value="valor")
    @ManyToOne
    @JoinColumn()
    private User user;

    @JsonBackReference(value="valor2")
    @ManyToOne
    @JoinColumn()
    private Boardgame boardgame;

    public Comment(){

    }

    public Comment(String content, User user, Boardgame boardgame) {
        this.content = content;
        this.user = user;
        this.boardgame = boardgame;

    }
}
