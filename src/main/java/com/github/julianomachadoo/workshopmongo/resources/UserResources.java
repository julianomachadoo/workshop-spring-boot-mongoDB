package com.github.julianomachadoo.workshopmongo.resources;

import com.github.julianomachadoo.workshopmongo.domain.User;
import com.github.julianomachadoo.workshopmongo.dto.UserDTO;
import com.github.julianomachadoo.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResources {

        @Autowired
        private UserService service;

        @GetMapping
        public ResponseEntity<List<UserDTO>> findAll() {
                List<User> list = service.findAll();
                List<UserDTO> listDTO = list.stream().map(UserDTO::new).collect(Collectors.toList());
                return ResponseEntity.ok().body(listDTO);
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<UserDTO> findById(@PathVariable String id) {
                User user = service.findById(id);
                return ResponseEntity.ok().body(new UserDTO(user));
        }
}
