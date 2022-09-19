package com.github.julianomachadoo.workshopmongo.services;

import com.github.julianomachadoo.workshopmongo.domain.User;
import com.github.julianomachadoo.workshopmongo.dto.UserDTO;
import com.github.julianomachadoo.workshopmongo.repository.UserRepository;
import com.github.julianomachadoo.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById (String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert (User user) {
        return repository.insert(user);
    }

    public void delete (String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user) {
        User newObj = findById(user.getId());
        updateData(newObj, user);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }


    public User fromDTO (UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
}
