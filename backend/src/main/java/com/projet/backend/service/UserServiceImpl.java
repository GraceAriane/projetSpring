package com.projet.backend.service;

import com.projet.backend.model.User;
import com.projet.backend.repository.RoleRepository;
import com.projet.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository){
        this.repository=repository;
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User newUser) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    return repository.save(user);
                }).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
