package com.github.julianomachadoo.workshopmongo.resources;

import com.github.julianomachadoo.workshopmongo.domain.Post;
import com.github.julianomachadoo.workshopmongo.domain.User;
import com.github.julianomachadoo.workshopmongo.dto.UserDTO;
import com.github.julianomachadoo.workshopmongo.services.PostService;
import com.github.julianomachadoo.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResources {

        @Autowired
        private PostService service;


        @GetMapping(value = "/{id}")
        public ResponseEntity<Post> findById(@PathVariable String id) {
                Post post = service.findById(id);
                return ResponseEntity.ok().body(post);
        }
}
