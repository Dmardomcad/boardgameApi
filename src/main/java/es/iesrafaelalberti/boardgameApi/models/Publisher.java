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
public class Publisher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer yearsActive;

    private String imagePublisher;

    @Column(length = 1500)
    private String info;
    @JsonManagedReference(value="manuelrivas")
    @OneToMany (mappedBy = "publisher", cascade = CascadeType.ALL)
    private Set<Boardgame> boardgame = new HashSet<>();


    public Publisher() {
    }

    public Publisher(String name, Integer yearsActive, String imagePublisher, String info) {
        this.name = name;
        this.yearsActive = yearsActive;
        this.imagePublisher = imagePublisher;
        this.info = info;
    }
}
