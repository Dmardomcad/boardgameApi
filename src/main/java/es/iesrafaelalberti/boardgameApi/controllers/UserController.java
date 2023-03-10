package es.iesrafaelalberti.boardgameApi.controllers;

import es.iesrafaelalberti.boardgameApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/")
    public ResponseEntity<Object> index(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

}
