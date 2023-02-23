package es.iesrafaelalberti.boardgameApi.boot;

import es.iesrafaelalberti.boardgameApi.models.Boardgame;
import es.iesrafaelalberti.boardgameApi.models.Publisher;
import es.iesrafaelalberti.boardgameApi.repository.BoardgameRepository;
import es.iesrafaelalberti.boardgameApi.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    BoardgameRepository boardGameRepository;
    @Autowired
    PublisherRepository publisherRepository;
    @Override
    public void run (String... args) {

        /*Publisher gw = (new Publisher(name: "gw"))
        Boardgame boardgame1 = boardGameRepository.save(new Boardgame("Warhammer","Juego wargame etc",60,"media", gw));
        Boardgame boardgame2 = boardGameRepository.save(new Boardgame("La Oca","Juego infantil",30,"fácil","Prueba1"));
        Boardgame boardgame3 = boardGameRepository.save(new Boardgame("Pequeñas Grandes Mazmorras","Juego dungeon crawler",60,"media","Prueba2"));*/

    }
}
