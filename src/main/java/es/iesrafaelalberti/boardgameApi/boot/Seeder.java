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
        User testUser = new User("dmardom", "dmardom@alberti.es", "pestillo1", "España");
        userRepository.save(testUser);
        // Manually publishers creation
        List<Publisher> publishers = new ArrayList<>();

        Publisher gamesworkshop = new Publisher("Games Workshop",20, "https://i.ibb.co/BwMGGkw/Games-Workshop-logo-svg.png", "Games Workshop es una empresa británica especializada en juegos de mesa y miniaturas. Son conocidos mundialmente por su popular juego de miniaturas Warhammer 40.000, que se desarrolla en un universo de ciencia ficción futurista. Games Workshop crea juegos de estrategia táctica que involucran la construcción, pintura y personalización de miniaturas, así como la planificación de estrategias y batallas en un mundo de fantasía y ciencia ficción.");
        publishers.add(gamesworkshop);

        //Publisher devir = new Publisher("Devir",5);
        //publishers.add(devir);

        //Publisher corvusbelli = new Publisher("Corvus Belli", 10);
        //publishers.add(corvusbelli);

        //Publisher wyrdgames = new Publisher("Wyrd Games", 2);
        //publishers.add(wyrdgames);

        Publisher mattelgames = new Publisher("Mattel Games", 10, "https://i.ibb.co/72WPv7B/logo.png", "Mattel Games es una reconocida empresa de juguetes y juegos de mesa con sede en Estados Unidos. Han sido líderes en la industria del entretenimiento durante décadas y son conocidos por crear juegos populares como Uno, Pictionary, Scrabble, entre otros. Mattel Games se enfoca en desarrollar juegos divertidos, accesibles y adecuados para toda la familia, y su amplio catálogo abarca una variedad de géneros y estilos de juego.");
        publishers.add(mattelgames);

        Publisher asmodee = new Publisher("Asmodee", 3, "https://i.ibb.co/3rFPWK3/Asmodee-svg.png", "Asmodee es una empresa francesa líder en la industria de juegos de mesa. Se dedican a la publicación, desarrollo y distribución de una amplia gama de juegos de mesa, tanto propios como de otras editoriales. Asmodee es conocida por ofrecer juegos innovadores y de alta calidad, abarcando diversos géneros y mecánicas de juego. Además, han adquirido numerosas editoriales de renombre, lo que les ha permitido contar con un amplio catálogo de juegos populares como Jungle Speed, Catan, Ticket to Ride, entre otros.");
        publishers.add(asmodee);

        publisherRepository.saveAll(publishers);
        // Manually games creation
        List<Boardgame> boardgames = new ArrayList<>();

        Boardgame warhammer40k = new Boardgame("Warhammer 40.000", " Juego de miniaturas de estrategia ambientado en un futuro distópico, en donde se mezclan elementos de la ciencia ficción con elementos de la fantasía heroica.", "https://i.ibb.co/d7DKKCH/w1.png", "https://i.ibb.co/CQyYzj3/warhammer-40000-open-war.jpg", 240, "Alta", "Miniaturas", gamesworkshop);
        boardgames.add(warhammer40k);

        Boardgame necromunda = new Boardgame("Necromunda", "Adéntrate en el mundo de los juegos de guerra de escaramuzas con Necromunda: Hive War. Elige tu banda y lucha en emocionantes y trepidantes partidas tácticas ambientadas en la oscuridad de la infracolmena.", "https://i.ibb.co/T88QVd9/w2.png", "https://i.ibb.co/MGP1qS5/necromunda-underhive-badzone-delta-7.jpg", 240,"Alta" ,"Miniaturas", gamesworkshop);
        boardgames.add(necromunda);

        Boardgame whunderworlds = new Boardgame("Warhammer Underworlds", "Juego de mesa trepidante y lleno de acción en el que bandas luchan por la gloria en los oscuros rincones de los Reinos Mortales.", "https://i.ibb.co/QMz3cCj/u-Jo-J8-Slq-SSY0nnc-I.png", "https://i.ibb.co/FYyVrzN/warhammer-undergrounds-beastgrave.jpg", 240, "Media","Miniaturas", gamesworkshop);
        boardgames.add(whunderworlds);

        Boardgame uno = new Boardgame("Uno", "Juego de cartas donde debes deshacerte de todas tus cartas coincidiendo en color o número.", "https://i.ibb.co/jzLJgG8/uno1.png", "https://i.ibb.co/d7DKKCH/w1.png", 15,"Baja","Cartas", mattelgames);
        boardgames.add(uno);

        Boardgame junglespeed = new Boardgame("Jungle Speed", " Juego de velocidad y reflejos donde los jugadores deben agarrar rápidamente el tótem al coincidir símbolos en las cartas.", "https://i.ibb.co/f1LmLXN/taboo.png", "https://i.ibb.co/SPDTMHy/jungle-speed-bertone.jpg", 15, "Baja","Habilidad",asmodee);
        boardgames.add(junglespeed);

        Boardgame hombreslobo = new Boardgame("Hombres Lobo", "Juego de deducción social donde los aldeanos intentan descubrir y eliminar a los hombres lobo.", "https://i.ibb.co/zb6Dx8Y/lobo.png", "https://i.ibb.co/d7DKKCH/w1.png", 15,"Baja","Social", asmodee);
        boardgames.add(hombreslobo);

        Boardgame explodingkittens = new Boardgame("Exploding Kittens", "Juego para los más pequeños en el que sacarán los dientes a un cocodrilo mientras evitan que el juguete les muerda.", "https://i.ibb.co/BLhTFJv/Juego-De-Mesa-Exploding-Kittens.png", "https://i.ibb.co/WKyGyyZ/exploding-kittens.png", 15,"Baja","Social", asmodee);
        boardgames.add(explodingkittens);

        Boardgame starwarsunlimited = new Boardgame("Star Wars: Unlimited", "¡Adéntrate en una galaxia de infinitas posibilidades con Star Wars™: Unlimited! Con las sencillas reglas de este trepidante juego de cartas coleccionables, tu adversario y tú os enfrentaréis en emocionantes batallas protagonizadas por los personajes más emblemáticos del universo de Star Wars. ¡Protege a tus aliados como Luke Skywalker o lanza una devastadora ofensiva como Darth Vader!\n" +
                "\n", "https://i.ibb.co/hDx0chh/Star-Wars-Unlimited-OP-Kit-Spread-Launch-Kit-941e337a76.png", "https://i.ibb.co/BrxWZ9s/swu-la-chispa-de-la-rebelion-caja-inicio.png", 30,"Media","Cartas", asmodee);
        boardgames.add(starwarsunlimited);

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
