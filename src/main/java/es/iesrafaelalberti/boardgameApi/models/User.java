package es.iesrafaelalberti.boardgameApi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usercustom")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String email;
    private String password;
    private String country;

    @JsonManagedReference(value = "valor")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Comment> comment = new HashSet<>();

    public User(String username,String email, String password, String country) {
        this.username = username;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.country = country;
    }
}