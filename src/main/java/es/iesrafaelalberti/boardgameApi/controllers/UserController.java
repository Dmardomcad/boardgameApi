package es.iesrafaelalberti.boardgameApi.controllers;

import es.iesrafaelalberti.boardgameApi.dto.UserDTO;
import es.iesrafaelalberti.boardgameApi.models.User;
import es.iesrafaelalberti.boardgameApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<Object> index(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<Object> show(@PathVariable("username") String username) {
        return new ResponseEntity<>(new UserDTO(userRepository.findByUsername(username)), HttpStatus.OK);
    }
    @GetMapping("/users/id/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping("/users/create")
    public ResponseEntity<Object> create(@RequestBody User user){
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(value -> userRepository.delete(value));
        return new ResponseEntity<>(user.isPresent(),HttpStatus.OK);
    }
    @PutMapping("users/{id}")
    public ResponseEntity<Object> update(@PathVariable("id")Long id, @RequestBody User user){
        Optional<User> oldUser = userRepository.findById(id);
        if(oldUser.isPresent()){
            user.setId(id);
            userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("users/exists/{username}")
    public ResponseEntity<Map<String, Boolean>> checkExists(@PathVariable("username") String username) {
        boolean exists = userRepository.existsByUsername(username);

        // Crear una respuesta con la bandera "exists"
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);

        return ResponseEntity.ok(response);
    }
}
