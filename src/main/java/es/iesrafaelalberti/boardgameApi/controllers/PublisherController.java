package es.iesrafaelalberti.boardgameApi.controllers;

import es.iesrafaelalberti.boardgameApi.models.Publisher;
import es.iesrafaelalberti.boardgameApi.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @DeleteMapping("/publishers/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Publisher> publisher = publisherRepository.findById(id);
        publisher.ifPresent(value -> publisherRepository.delete(value));
        return new ResponseEntity<>(publisher.isPresent(),HttpStatus.OK);
    }
    @PutMapping("/publishers/{id}")
    public ResponseEntity<Object> update(@PathVariable("id")Long id, @RequestBody Publisher publisher){
        Optional<Publisher> oldPublisher = publisherRepository.findById(id);
        if(oldPublisher.isPresent()){
            publisher.setId(id);
            publisherRepository.save(publisher);
            return new ResponseEntity<>(publisher,HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

    }

    }

