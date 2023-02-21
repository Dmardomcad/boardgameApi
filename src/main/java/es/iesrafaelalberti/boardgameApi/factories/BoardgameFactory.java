package es.iesrafaelalberti.boardgameApi.factories;

import com.github.javafaker.Faker;
import es.iesrafaelalberti.boardgameApi.models.Boardgame;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class BoardgameFactory {
    Faker esFaker = new Faker(new Locale("es-Es"));

    Random rand = new Random();



}
