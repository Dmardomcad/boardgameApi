package es.iesrafaelalberti.boardgameApi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Boardgame {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private Integer duration;

    private String difficulty;

    @JsonIgnoreProperties("id") //Con JsonIgnoreProperties el atributo que se le indique no aparecerá en la consulta http
    @ManyToOne
    @JoinColumn()
    private Publisher publisher;
    public Boardgame() {
    }

    public Boardgame(String name, String description, Integer duration, String difficulty, Publisher publisher) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.difficulty = difficulty;
        this.publisher = publisher;
    }
}
