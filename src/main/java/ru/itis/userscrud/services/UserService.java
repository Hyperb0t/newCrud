package ru.itis.userscrud.services;

import ru.itis.userscrud.dto.UserRegFormDto;
import ru.itis.userscrud.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User registerUser(UserRegFormDto userRegFormDto);
    public List<User> getAllUsers();
    public Optional<User> getUserById(Integer id);
    public User addUser(User user);
    public boolean deleteUser(Integer id);
}
