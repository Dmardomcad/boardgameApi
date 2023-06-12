package es.iesrafaelalberti.boardgameApi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
public class Boardgame {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String detailImage;

    private Integer duration;

    private String difficulty;

    @JsonBackReference(value="manuelrivas")
    @ManyToOne
    @JoinColumn()
    private Publisher publisher;

    @JsonManagedReference(value = "valor2")
    @OneToMany(mappedBy = "boardgame", cascade = CascadeType.ALL)
    private Set<Comment> comment = new HashSet<>();

    public Boardgame() {
    }

    public Boardgame(String name, String description,String detailImage, Integer duration, String difficulty, Publisher publisher) {
        this.name = name;
        this.description = description;
        this.detailImage = detailImage;
        this.duration = duration;
        this.difficulty = difficulty;
        this.publisher = publisher;
    }
}
