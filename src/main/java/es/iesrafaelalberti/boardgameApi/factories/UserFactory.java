package es.iesrafaelalberti.boardgameApi.factories;

import com.github.javafaker.Faker;
import es.iesrafaelalberti.boardgameApi.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class UserFactory {
    Faker esFaker = new Faker(new Locale("es-ES"));

    public List<User> getOldSchool(int number){
        List<User> users = new ArrayList<>();
        for(int i=0;i<number; i++)
            users.add(new User(esFaker.name().username(),
                    esFaker.internet().password()));
        return users;
    }
}
