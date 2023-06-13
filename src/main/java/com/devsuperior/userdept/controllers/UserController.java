package com.devsuperior.userdept.controllers;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    //Retorna a lista de usuarios
    @GetMapping
    public List<User>findAll(){
       List<User> result = repository.findAll();
       return result;
    }

    //Retorna um usuario pelo id
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        User result = repository.findById(id).get();
        return result;
    }

    //Insere usuarios
    @PostMapping
    public User insert(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }

    //Deleta usuario pelo id
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object>deleteById(@PathVariable(value = "id") Long id){
        Optional<User>userOptional = repository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete successfully.");
    }


}
