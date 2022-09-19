package com.github.julianomachadoo.workshopmongo.resources;

import com.github.julianomachadoo.workshopmongo.domain.User;
import com.github.julianomachadoo.workshopmongo.dto.UserDTO;
import com.github.julianomachadoo.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResources {

        @Autowired
        private UserService service;

        @GetMapping
        public ResponseEntity<List<UserDTO>> findAll() {
                List<User> list = service.findAll();
                List<UserDTO> listDTO = list.stream().map(l -> new UserDTO(l.getName(), l.getEmail())).collect(Collectors.toList());
                return ResponseEntity.ok().body(listDTO);
        }
}
