package com.projet.backend.service;
import com.projet.backend.model.User;
import java.util.List;
import java.util.Optional;
public interface UserService {
    public User saveUser(User user);
    public Optional<User> getUserById(Long id);
    public void deleteUserById(Long id);
    public User updateUser(Long id, User newUser);
    public List<User> getAllUsers();

}
