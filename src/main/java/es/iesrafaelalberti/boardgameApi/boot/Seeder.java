package es.iesrafaelalberti.boardgameApi.boot;

import es.iesrafaelalberti.boardgameApi.factories.BoardgameFactory;
import es.iesrafaelalberti.boardgameApi.factories.CommentFactory;
import es.iesrafaelalberti.boardgameApi.factories.PublisherFactory;
import es.iesrafaelalberti.boardgameApi.factories.UserFactory;
import es.iesrafaelalberti.boardgameApi.models.Boardgame;
import es.iesrafaelalberti.boardgameApi.models.Comment;
import es.iesrafaelalberti.boardgameApi.models.Publisher;
import es.iesrafaelalberti.boardgameApi.models.User;
import es.iesrafaelalberti.boardgameApi.repository.BoardgameRepository;
import es.iesrafaelalberti.boardgameApi.repository.CommentRepository;
import es.iesrafaelalberti.boardgameApi.repository.PublisherRepository;
import es.iesrafaelalberti.boardgameApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        // Manual seeders
        User testUser = new User("dmardom", "dmardom@alberti.es", "pestillo");
        userRepository.save(testUser);
        // Manually publishers creation
        Publisher gamesworkshop = new Publisher("Games Workshop",20);
        List<Publisher> publishers = new ArrayList<>();
        publishers.add(gamesworkshop);
        publisherRepository.saveAll(publishers);
        // Manually games creation
        List<Boardgame> boardgames = new ArrayList<>();

        Boardgame warhammer40k = new Boardgame("Warhammer 40.000", "Juego de miniaturas coleccionables, simulando batallas de un fúturo oscuro.", "https://i.ibb.co/vZq3HZX/60010199031-WH40-KElite-Edition-Stock.webp", 240, "Hard", gamesworkshop);
        boardgames.add(warhammer40k);

        Boardgame uno = new Boardgame("Uno", "Juego de cartas sencillo para toda la familia.", "https://i.ibb.co/9GFnVBC/Uno.jpg", 15, "Easy", gamesworkshop);
        boardgames.add(uno);

        Boardgame junglespeed = new Boardgame("Jungle Speed", "Juego de reflejos y velocidad.", "https://i.ibb.co/Wg74HjM/jungle.png", 15, "Easy", gamesworkshop);
        boardgames.add(junglespeed);

        Boardgame hombreslobo = new Boardgame("Hombres Lobo", "Juego de cartas y engaño.", "https://i.ibb.co/DbS5vFm/hombres-lobo.jpg", 15, "Easy", gamesworkshop);
        boardgames.add(hombreslobo);

        boardGameRepository.saveAll(boardgames);


        // Auto seeders using factories
        List<User> users = userFactory.getOldSchool(10);
        userRepository.saveAll(users);

       /* List<Publisher> publishers = publisherFactory.getOldSchool(10);
        publisherRepository.saveAll(publishers);
        List<Boardgame> boardgames = boardgameFactory.getOldSchool(10, publishers);
        boardGameRepository.saveAll(boardgames); */

        commentRepository.saveAll(commentFactory.getOldSchool(10,users, boardgames));

        //boardGameRepository.saveAll(boardgameFactory.getOldSchool(10, publishers));
        /*Publisher gw = (new Publisher(name: "gw"))
        Boardgame boardgame1 = boardGameRepository.save(new Boardgame("Warhammer","Juego wargame etc",60,"media", gw));
        Boardgame boardgame2 = boardGameRepository.save(new Boardgame("La Oca","Juego infantil",30,"fácil","Prueba1"));
        Boardgame boardgame3 = boardGameRepository.save(new Boardgame("Pequeñas Grandes Mazmorras","Juego dungeon crawler",60,"media","Prueba2"));*/

    }
}
