package com.github.julianomachadoo.workshopmongo.resources;

import com.github.julianomachadoo.workshopmongo.domain.User;
import com.github.julianomachadoo.workshopmongo.dto.UserDTO;
import com.github.julianomachadoo.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

        @PostMapping
        public ResponseEntity<Void> insert(@RequestBody UserDTO dto) {
                User insert = service.insert(service.fromDTO(dto));
                URI uri = ServletUriComponentsBuilder
                        .fromCurrentRequestUri()
                        .path("/{id}")
                        .buildAndExpand(insert.getId()).toUri();
                return ResponseEntity.created(uri).build();
        }

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<Void> deleteById (@PathVariable String id) {
                service.delete(id);
                return ResponseEntity.noContent().build();
        }
}
