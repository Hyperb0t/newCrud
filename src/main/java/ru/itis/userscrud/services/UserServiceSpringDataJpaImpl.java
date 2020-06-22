package ru.itis.userscrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.userscrud.dao.JpaUserRepository;
import ru.itis.userscrud.dto.UserRegFormDto;
import ru.itis.userscrud.models.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//@Service
public class UserServiceSpringDataJpaImpl implements UserService {

    @Autowired
    private JpaUserRepository userRepository;

    @Override
    public User registerUser(UserRegFormDto userRegFormDto) {
        User user = User.fromFormDto(userRegFormDto);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), true).
                collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        userRepository.deleteById(id);
        return true;
        //sad((
    }
}
