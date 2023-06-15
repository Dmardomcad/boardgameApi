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
        List<Publisher> publishers = new ArrayList<>();

        Publisher gamesworkshop = new Publisher("Games Workshop",20, "https://i.ibb.co/BwMGGkw/Games-Workshop-logo-svg.png");
        publishers.add(gamesworkshop);

        //Publisher devir = new Publisher("Devir",5);
        //publishers.add(devir);

        //Publisher corvusbelli = new Publisher("Corvus Belli", 10);
        //publishers.add(corvusbelli);

        //Publisher wyrdgames = new Publisher("Wyrd Games", 2);
        //publishers.add(wyrdgames);

        Publisher mattelgames = new Publisher("Mattel Games", 10, "https://i.ibb.co/gz1VRLx/Mattel-Games.webp");
        publishers.add(mattelgames);

        Publisher asmodee = new Publisher("Asmodee", 3, "https://i.ibb.co/3rFPWK3/Asmodee-svg.png");
        publishers.add(asmodee);

        publisherRepository.saveAll(publishers);
        // Manually games creation
        List<Boardgame> boardgames = new ArrayList<>();

        Boardgame warhammer40k = new Boardgame("Warhammer 40.000", " Juego de miniaturas de estrategia ambientado en un futuro distópico, en donde se mezclan elementos de la ciencia ficción con elementos de la fantasía heroica.", "https://i.ibb.co/vZq3HZX/60010199031-WH40-KElite-Edition-Stock.webp", 240, "Alta", gamesworkshop);
        boardgames.add(warhammer40k);

        Boardgame necromunda = new Boardgame("Necromunda", "Adéntrate en el mundo de los juegos de guerra de escaramuzas con Necromunda: Hive War. Elige tu banda y lucha en emocionantes y trepidantes partidas tácticas ambientadas en la oscuridad de la infracolmena.", "https://i.ibb.co/c3pqcTZ/60010599003-Hive-War-Lead.webp", 240, "Alta", gamesworkshop);
        boardgames.add(necromunda);

        Boardgame whunderworlds = new Boardgame("Warhammer Underworlds", "Juego de mesa trepidante y lleno de acción en el que bandas luchan por la gloria en los oscuros rincones de los Reinos Mortales.", "https://i.ibb.co/1QTsz3y/03010799020-SPAWHUStarter-Set1.jpg", 240, "Media", gamesworkshop);
        boardgames.add(whunderworlds);

        Boardgame uno = new Boardgame("Uno", "Juego de cartas donde debes deshacerte de todas tus cartas coincidiendo en color o número.", "https://i.ibb.co/9GFnVBC/Uno.jpg", 15, "Baja", mattelgames);
        boardgames.add(uno);

        Boardgame junglespeed = new Boardgame("Jungle Speed", " Juego de velocidad y reflejos donde los jugadores deben agarrar rápidamente el tótem al coincidir símbolos en las cartas.", "https://i.ibb.co/Wg74HjM/jungle.png", 15, "Baja", asmodee);
        boardgames.add(junglespeed);

        Boardgame hombreslobo = new Boardgame("Hombres Lobo", "Juego de deducción social donde los aldeanos intentan descubrir y eliminar a los hombres lobo.", "https://i.ibb.co/DbS5vFm/hombres-lobo.jpg", 15, "Baja", asmodee);
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
