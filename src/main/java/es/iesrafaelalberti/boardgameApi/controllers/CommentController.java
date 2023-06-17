package es.iesrafaelalberti.boardgameApi.controllers;

import es.iesrafaelalberti.boardgameApi.dto.CommentDTO;
import es.iesrafaelalberti.boardgameApi.models.Comment;
import es.iesrafaelalberti.boardgameApi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments")
    public ResponseEntity<Object> index() {
        List<CommentDTO> result = new ArrayList<>();
        for(Comment comment:commentRepository.findAll())
            result.add(new CommentDTO(comment));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Object> show(@PathVariable("id")Long id) {
        return new ResponseEntity<>(new CommentDTO(commentRepository.findById(id).get()), HttpStatus.OK);
    }
    /* public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);

        if (commentOptional.isPresent()) {
            Comment comment = commentOptional.get();
            CommentDTO commentDTO = new CommentDTO(comment.getId(), comment.getBoardgame().getId(), comment.getContent(), comment.getUser().getUsername());

            return new ResponseEntity<>(commentDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } */

    // Old way before DTO
    /*
    public ResponseEntity<Object> show(@PathVariable("id")Long id){
        return new ResponseEntity<>(commentRepository.findById(id), HttpStatus.OK);
    } */
    @PostMapping("/comments/create")
    public ResponseEntity<Object> create(@RequestBody Comment comment){
        commentRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        comment.ifPresent(value -> commentRepository.delete(value));
        return new ResponseEntity<>(comment.isPresent(), HttpStatus.OK);
    }
    @PutMapping("/comments/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Comment comment ){
        Optional<Comment> oldComment = commentRepository.findById(id);
        if(oldComment.isPresent()){
            comment.setId(id);
            commentRepository.save(comment);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
