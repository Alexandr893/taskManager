package org.example.taskmanager.service;

import lombok.AllArgsConstructor;
import org.example.taskmanager.dao.entity.User;
import org.example.taskmanager.dao.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User createUser(User user) {
        // Валидация
        if (!StringUtils.hasText(user.getEmail())) {
            throw new IllegalArgumentException("Email не может быть пустым");
        }
        if (!StringUtils.hasText(user.getFirstName())) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (!StringUtils.hasText(user.getPassword())) {
            throw new IllegalArgumentException("Пароль не может быть пустым");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Пользователь с таким email уже существует");
        }

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
