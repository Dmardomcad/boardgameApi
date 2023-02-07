package es.iesrafaelalberti.boardgameApi.controllers;

import es.iesrafaelalberti.boardgameApi.models.Publisher;
import es.iesrafaelalberti.boardgameApi.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PublisherController {
    @Autowired
    PublisherRepository publisherRepository;

    @GetMapping("/publishers/")
    public ResponseEntity<Object> index(){ return new ResponseEntity<>(publisherRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/publishers/{id}")
    public ResponseEntity<Object> show(@PathVariable("id")Long id){
        return new ResponseEntity<>(publisherRepository.findById(id),HttpStatus.OK);
    }
    @PostMapping("/publishers/create")
    public ResponseEntity<Object> create(@RequestBody Publisher publisher){
        publisherRepository.save(publisher);
        return new ResponseEntity<>(publisher,HttpStatus.OK);
        }
    }
