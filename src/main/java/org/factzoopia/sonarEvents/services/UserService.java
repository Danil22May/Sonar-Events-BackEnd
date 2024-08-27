package org.factzoopia.sonarEvents.services;

import java.util.List;

import org.factzoopia.sonarEvents.models.User;
import org.factzoopia.sonarEvents.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired

    private UserRepository repository;
    
    public User createUser(User user) {
        return repository.save(user);
    }

 public List<User> getAllUsers() {
        return repository.findAll();
    }

}
