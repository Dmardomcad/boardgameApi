package es.iesrafaelalberti.boardgameApi.controllers;

import es.iesrafaelalberti.boardgameApi.models.Boardgame;
import es.iesrafaelalberti.boardgameApi.repository.BoardgameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BoardgameController {
    @Autowired
    BoardgameRepository boardGameRepository;

    @GetMapping("/boardgames/")
    public ResponseEntity<Object> index() {return new ResponseEntity<>(boardGameRepository.findAll(), HttpStatus.OK);}

    @GetMapping("/boardgames/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id ){
        return new ResponseEntity<>(boardGameRepository.findById(id),HttpStatus.OK);
    }
    @PostMapping("/boardgames/create")
    public ResponseEntity<Object> create(@RequestBody Boardgame boardgame){
        boardGameRepository.save(boardgame);
        return new ResponseEntity<>(boardgame, HttpStatus.OK);
    }
    @DeleteMapping("/boardgames/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Boardgame> boardGame = boardGameRepository.findById(id);
        boardGame.ifPresent(value -> boardGameRepository.delete(value));
        return new ResponseEntity<>(boardGame.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/boardgames/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Boardgame boardgame) {
        Optional<Boardgame> oldBoardgame = boardGameRepository.findById(id);
        if(oldBoardgame.isPresent()) {
            boardgame.setId(id);
            boardGameRepository.save(boardgame);
            return new ResponseEntity<>(boardgame, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
