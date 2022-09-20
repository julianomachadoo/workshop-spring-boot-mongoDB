package com.github.julianomachadoo.workshopmongo.services;

import com.github.julianomachadoo.workshopmongo.domain.Post;
import com.github.julianomachadoo.workshopmongo.repository.PostRepository;
import com.github.julianomachadoo.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle (String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
