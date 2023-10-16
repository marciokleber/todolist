package br.com.marciokleber.todolist.controller;

import br.com.marciokleber.todolist.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping()
    public String show(@RequestBody User user){
        return user.getName();
    }

}
