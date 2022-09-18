package com.github.julianomachadoo.workshopmongo.resources;

import com.github.julianomachadoo.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResources {

        @GetMapping
        public ResponseEntity<List<User>> findAll() {
                return ResponseEntity.ok().build();
        }
}
