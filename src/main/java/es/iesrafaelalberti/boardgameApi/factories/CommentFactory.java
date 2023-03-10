package es.iesrafaelalberti.boardgameApi.factories;

import com.github.javafaker.Faker;
import es.iesrafaelalberti.boardgameApi.models.Boardgame;
import es.iesrafaelalberti.boardgameApi.models.Comment;
import es.iesrafaelalberti.boardgameApi.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class CommentFactory {
    Faker esFaker = new Faker(new Locale("es-Es"));

    Random rand = new Random();

    public List<Comment> getOldSchool(int number, List<User> users, List<Boardgame> boardgames) {
        List<Comment> comments = new ArrayList<>();
        for(int i = 0; i < number; i++)
            comments.add(new Comment(esFaker.lorem().paragraph(),
                    users.get(rand.nextInt(users.size())),
                    boardgames.get(rand.nextInt(boardgames.size()))));
        return comments;
    }

}
