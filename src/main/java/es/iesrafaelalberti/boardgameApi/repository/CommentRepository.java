package es.iesrafaelalberti.boardgameApi.repository;

import es.iesrafaelalberti.boardgameApi.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {}
