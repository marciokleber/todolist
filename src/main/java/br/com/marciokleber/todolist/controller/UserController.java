package br.com.marciokleber.todolist.controller;

import br.com.marciokleber.todolist.domain.User;
import br.com.marciokleber.todolist.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity save(@RequestBody User user) {
        if(userRepository.findByUserName(user.getUsername()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable("id") Long id ){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findById(id));
    }
    @GetMapping()
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id ){
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário Deletado Com sucesso!");
    }
}
