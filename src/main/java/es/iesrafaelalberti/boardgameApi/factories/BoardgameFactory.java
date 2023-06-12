package es.iesrafaelalberti.boardgameApi.factories;

import es.iesrafaelalberti.boardgameApi.factories.BoardgameFactory;
import com.github.javafaker.Faker;
import es.iesrafaelalberti.boardgameApi.models.Boardgame;
import es.iesrafaelalberti.boardgameApi.models.Publisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class BoardgameFactory {
    Faker esFaker = new Faker(new Locale("es-Es"));

    Random rand = new Random();

    public List<Boardgame> getOldSchool(int number, List<Publisher> publishers) {
        List<Boardgame> boardgames = new ArrayList<>();
        for (int i = 0; i < number; i++)
            boardgames.add(new Boardgame(esFaker.name().firstName(),
                    esFaker.name().firstName(),
                    esFaker.name().firstName(),
                    esFaker.number().numberBetween(10,160),
                    esFaker.name().firstName(),
                    publishers.get(rand.nextInt(publishers.size()))));


        return boardgames;
    }
}
