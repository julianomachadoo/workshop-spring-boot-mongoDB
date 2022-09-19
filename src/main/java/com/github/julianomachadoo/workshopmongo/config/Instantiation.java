package com.github.julianomachadoo.workshopmongo.config;

import com.github.julianomachadoo.workshopmongo.domain.Post;
import com.github.julianomachadoo.workshopmongo.domain.User;
import com.github.julianomachadoo.workshopmongo.dto.AuthorDTO;
import com.github.julianomachadoo.workshopmongo.dto.CommentDTO;
import com.github.julianomachadoo.workshopmongo.repository.PostRepository;
import com.github.julianomachadoo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null,
                LocalDate.of(2018, 03, 21),
                "Partiu viagem",
                "Vou viajar para São Paulo. Abraços!",
                new AuthorDTO(maria));

        Post post2 = new Post(null,
                LocalDate.of(2018, 03, 23),
                "Bom dia",
                "Acordei feliz hoje!",
                new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!",
                LocalDate.of(2018, 03, 21),
                new AuthorDTO(alex));

        CommentDTO c2 = new CommentDTO("Aproveite!",
                LocalDate.of(2018, 03, 22),
                new AuthorDTO(bob));

        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!",
                LocalDate.of(2018, 03, 23),
                new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
