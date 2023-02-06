package es.iesrafaelalberti.boardgameApi.repository;

import es.iesrafaelalberti.boardgameApi.models.Boardgame;
import org.springframework.data.repository.CrudRepository;

public interface BoardgameRepository extends CrudRepository<Boardgame, Long> {
}
