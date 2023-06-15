package es.iesrafaelalberti.boardgameApi.factories;

import com.github.javafaker.Faker;
import es.iesrafaelalberti.boardgameApi.models.Publisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class PublisherFactory {
    Faker esFaker = new Faker(new Locale("es-ES"));
    Random rand = new Random();

    public List<Publisher> getOldSchool(int number){

        List<Publisher> publishers = new ArrayList<>();
        for(int i=0;i<number; i++)
            publishers.add(new Publisher(esFaker.name().firstName(),
                                        esFaker.number().randomDigit(),
                                        esFaker.name().firstName()
                    ));

    return publishers;
    }


}
