package es.iesrafaelalberti.boardgameApi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
public class Publisher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer yearsActive;
    @JsonBackReference
    @OneToMany (mappedBy = "publisher", cascade = CascadeType.ALL)
    private Set<Boardgame> boardgame = new HashSet<>();


    public Publisher() {
    }

    public Publisher(String name, Integer yearsActive) {
        this.name = name;
        this.yearsActive = yearsActive;
    }
}
