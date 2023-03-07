package es.iesrafaelalberti.boardgameApi.repository;

import es.iesrafaelalberti.boardgameApi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
