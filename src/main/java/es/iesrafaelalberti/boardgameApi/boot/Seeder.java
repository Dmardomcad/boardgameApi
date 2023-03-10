package es.iesrafaelalberti.boardgameApi.boot;

import es.iesrafaelalberti.boardgameApi.factories.BoardgameFactory;
import es.iesrafaelalberti.boardgameApi.factories.CommentFactory;
import es.iesrafaelalberti.boardgameApi.factories.PublisherFactory;
import es.iesrafaelalberti.boardgameApi.factories.UserFactory;
import es.iesrafaelalberti.boardgameApi.models.Publisher;
import es.iesrafaelalberti.boardgameApi.models.User;
import es.iesrafaelalberti.boardgameApi.repository.BoardgameRepository;
import es.iesrafaelalberti.boardgameApi.repository.CommentRepository;
import es.iesrafaelalberti.boardgameApi.repository.PublisherRepository;
import es.iesrafaelalberti.boardgameApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    BoardgameRepository boardGameRepository;
    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    PublisherFactory publisherFactory;
    @Autowired
    BoardgameFactory boardgameFactory;
    @Autowired
    CommentFactory commentFactory;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserFactory userFactory;

    // Falta introducir los datos para los comments
    @Override
    public void run (String... args) {
        User testUser = new User("dmardom", "pestillo");
        userRepository.save(testUser);

        List<User> users = userFactory.getOldSchool(10);
        userRepository.saveAll(users);

        List<Publisher> publishers = publisherFactory.getOldSchool(10);
        publisherRepository.saveAll(publishers);

        boardGameRepository.saveAll(boardgameFactory.getOldSchool(10, publishers));
        /*Publisher gw = (new Publisher(name: "gw"))
        Boardgame boardgame1 = boardGameRepository.save(new Boardgame("Warhammer","Juego wargame etc",60,"media", gw));
        Boardgame boardgame2 = boardGameRepository.save(new Boardgame("La Oca","Juego infantil",30,"fácil","Prueba1"));
        Boardgame boardgame3 = boardGameRepository.save(new Boardgame("Pequeñas Grandes Mazmorras","Juego dungeon crawler",60,"media","Prueba2"));*/

    }
}
