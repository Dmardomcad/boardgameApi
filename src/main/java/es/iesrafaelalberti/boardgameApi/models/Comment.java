package es.iesrafaelalberti.boardgameApi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @JsonBackReference(value="valor")
    @ManyToOne
    @JoinColumn()
    private User user;
    public Comment(){

    }

    public Comment(String content, User user) {
        this.content = content;
        this.user = user;
    }
}
