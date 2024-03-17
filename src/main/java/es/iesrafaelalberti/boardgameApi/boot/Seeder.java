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

        Publisher gamesworkshop = new Publisher("Games Workshop",2004, "https://i.ibb.co/BwMGGkw/Games-Workshop-logo-svg.png", "Games Workshop es una empresa británica especializada en juegos de mesa y miniaturas. Son conocidos mundialmente por su popular juego de miniaturas Warhammer 40.000, que se desarrolla en un universo de ciencia ficción futurista. Games Workshop crea juegos de estrategia táctica que involucran la construcción, pintura y personalización de miniaturas, así como la planificación de estrategias y batallas en un mundo de fantasía y ciencia ficción.");
        publishers.add(gamesworkshop);

        //Publisher devir = new Publisher("Devir",5);
        //publishers.add(devir);

        //Publisher corvusbelli = new Publisher("Corvus Belli", 10);
        //publishers.add(corvusbelli);

        //Publisher wyrdgames = new Publisher("Wyrd Games", 2);
        //publishers.add(wyrdgames);

        Publisher devir = new Publisher("Devir", 2014, "https://i.ibb.co/6HpsF6N/logo-devir-caja-azul.png", "Devir es un grupo editorial brasileño fundado en 1987 y especializado en productos de ocio y entretenimiento: literatura fantástica, cómics y juegos de toda clase como juegos de rol, de tablero, de cartas coleccionables, de naipes, de miniaturas etc. El grupo tiene filiales en ocho países diferentes: Brasil, Portugal, España, Estados Unidos, Chile, Colombia, México y Argentina\n" +
                "\n");
        publishers.add(devir);

        Publisher ludonova = new Publisher("Ludonova", 2011,"https://i.ibb.co/9YKpd9N/logo-ludonova-web-small-e1697794771745.png","La editorial Ludonova nace en 2011 como respuesta a la creciente nueva tendencia de entretenimiento alternativo que traen consigo los juegos de mesa de nueva generación, también conocidos como juegos de mesa modernos o Eurogames.\n" +
                "\n" +
                "La idea inicial de la que nació este proyecto fue la de contribuir y formar parte de la propagación de este nuevo estilo de entretenimiento, poniendo a disposición de los aficionados españoles los mejores juegos del mercado en sus tiendas habituales y en castellano. Con el tiempo, la línea editorial de Ludonova ha ido creciendo e incorporando también juegos propios que se han exportado a otros mercados de todo el mundo.\n" +
                "\n");
        publishers.add(ludonova);

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

        Boardgame junglespeed = new Boardgame("Jungle Speed", " Juego de velocidad y reflejos donde los jugadores deben agarrar rápidamente el tótem al coincidir símbolos en las cartas.", "https://i.ibb.co/f1LmLXN/taboo.png", "https://i.ibb.co/SPDTMHy/jungle-speed-bertone.jpg", 15, "Baja","Habilidad",asmodee);
        boardgames.add(junglespeed);

        Boardgame hombreslobo = new Boardgame("Hombres Lobo", "Juego de deducción social donde los aldeanos intentan descubrir y eliminar a los hombres lobo.", "https://i.ibb.co/zb6Dx8Y/lobo.png", "https://i.ibb.co/d7DKKCH/w1.png", 15,"Baja","Social", asmodee);
        boardgames.add(hombreslobo);

        Boardgame explodingkittens = new Boardgame("Exploding Kittens", "Juego para los más pequeños en el que sacarán los dientes a un cocodrilo mientras evitan que el juguete les muerda.", "https://i.ibb.co/BLhTFJv/Juego-De-Mesa-Exploding-Kittens.png", "https://i.ibb.co/WKyGyyZ/exploding-kittens.png", 15,"Baja","Social", asmodee);
        boardgames.add(explodingkittens);

        Boardgame starwarsunlimited = new Boardgame("Star Wars: Unlimited", "¡Adéntrate en una galaxia de infinitas posibilidades con Star Wars™: Unlimited! Con las sencillas reglas de este trepidante juego de cartas coleccionables, tu adversario y tú os enfrentaréis en emocionantes batallas protagonizadas por los personajes más emblemáticos del universo de Star Wars. ¡Protege a tus aliados como Luke Skywalker o lanza una devastadora ofensiva como Darth Vader!\n" +
                "\n", "https://i.ibb.co/hDx0chh/Star-Wars-Unlimited-OP-Kit-Spread-Launch-Kit-941e337a76.png", "https://i.ibb.co/BrxWZ9s/swu-la-chispa-de-la-rebelion-caja-inicio.png", 30,"Media","Cartas", asmodee);
        boardgames.add(starwarsunlimited);

        Boardgame codigosecreto = new Boardgame("Código Secreto", "Código secreto es un juego en el que se mezcla la intriga, el espionaje y las claves secretas. ¡Ponte en la piel de un espía y descubre la identidad de tus compañeros! Este juego, eminentemente competitivo por equipos, requiere colaborar entre los miembros de cada bando para llegar, juntos, a la victoria.","https://i.ibb.co/h2sSXsx/codigo-secreto-bodegon-e1629146504162.png", "https://i.ibb.co/fNCkG9H/codigo-secreto.jpg", 40, "Media","Cartas",devir);
        boardgames.add(codigosecreto);

        Boardgame dungeonraiders = new Boardgame("Dungeon Raiders", "¡Únete al grupo de valientes aventureros! ¡Explora una mazmorra llena de monstruos, trampas y tesoros! En Dungeon Raiders, cada jugador toma el papel de un aventurero diferente. Tendréis que trabajar juntos para sobrevivir en la mazmorra, pero sólo uno de vosotros conseguirá salir con la mayor cantidad de tesoro posible y ganar el juego. La mazmorra es diferente cada vez que juegas, ofreciendo nuevas sorpresas a medida que avanzas por ella. Y, por si esto no fuese suficiente, ¡Al final te encontrarás con un terrible monstruo final!","https://i.ibb.co/1J092jx/juego-mesa-dungeon-raiders-2011-131325240.jpg","https://i.ibb.co/S7nfyTy/dungeon-raiders.jpg",30,"Media","Cartas", devir);
        boardgames.add(dungeonraiders);

        Boardgame polillatramposa = new Boardgame("Polilla Tramposa", "Normalmente en los juegos no se permite hacer trampas. ¡Pero en este juego sí! Se trata de ser el primer jugador en deshacerse de todas las cartas y por eso os hará falta ser ingeniosos a la hora de descartar y muy hábiles haciendo trampas.","https://i.ibb.co/D8kxw9R/polilla-tramposa-1200-components1.webp", "https://i.ibb.co/09VN7z4/polilla-tramposa.jpg", 30, "Fácil", "Cartas", devir);
        boardgames.add(polillatramposa);

        Boardgame ratzzia = new Boardgame("Ratzzia","Los dados representan a los ratones de la familia de cada jugador, y deberemos gestionar cada tirada colocando los diversos resultados en el tablero, para así acumular tanta comida como nos sea posible.","https://i.ibb.co/P9yksy5/rattzia.webp","https://i.ibb.co/1vRnXxQ/ratzzia.jpg", 20, "Fácil", "Social", devir);
        boardgames.add(ratzzia);

        Boardgame flickemup = new Boardgame("Flick em Up!", "\"Flick 'em up! Tierra de forajidos\" es un sorprendente juego de mesa de habilidad, de dos a diez jugadores, donde las figuras en tres dimensiones de vaqueros, cactus, barriles, edificios,... cobrarán vida y convertirán tu mesa en un turbulento y despiadado pueblo del lejano oeste.\n" +
                "\n" +
                "A través de diez escenarios diferentes, donde se sucederán atracos, secuestros, duelos y otros muchos retos a los que enfrentarse, este inmersivo y emocionante juego pondrá toda la acción de los clásicos westerns en la punta de tu dedo.","https://i.ibb.co/9s51Z9t/flick-em-up.webp","https://i.ibb.co/wB2jLBj/flick-em-up-tierra-de-forajidos.jpg" ,30, "Fácil", "Social", ludonova);
        boardgames.add(flickemup);

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
