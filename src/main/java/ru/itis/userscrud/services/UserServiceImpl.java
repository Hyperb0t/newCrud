package ru.itis.userscrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.itis.userscrud.dao.UserRepository;
import ru.itis.userscrud.dto.UserRegFormDto;
import ru.itis.userscrud.models.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    @Qualifier("UserRepoEntityManagerImpl")
    UserRepository userRepository;

    public User registerUser(UserRegFormDto userRegFormDto) {
        User user = User.fromFormDto(userRegFormDto);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.find(id);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public boolean deleteUser(Integer id) {
        return userRepository.delete(id);
    }
}
