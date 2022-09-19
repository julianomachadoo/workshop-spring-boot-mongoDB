package com.github.julianomachadoo.workshopmongo.resources;

import com.github.julianomachadoo.workshopmongo.domain.User;
import com.github.julianomachadoo.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResources {

        @Autowired
        private UserService service;

        @GetMapping
        public ResponseEntity<List<User>> findAll() {
                List<User> list = service.findAll();
                return ResponseEntity.ok().body(list);

        }
}
