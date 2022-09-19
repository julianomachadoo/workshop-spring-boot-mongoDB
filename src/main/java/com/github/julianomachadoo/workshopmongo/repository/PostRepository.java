package com.github.julianomachadoo.workshopmongo.repository;

import com.github.julianomachadoo.workshopmongo.domain.Post;
import com.github.julianomachadoo.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
