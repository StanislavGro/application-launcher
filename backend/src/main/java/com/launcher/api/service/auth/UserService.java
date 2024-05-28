package com.launcher.api.service.auth;

import com.launcher.api.entities.User;
import com.launcher.api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User saveUser(User newUser) {
        getUserByLogin(newUser.getFirstName())
                .ifPresent(s -> {
                    throw new RuntimeException("User has already exist");
                });
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    public Optional<User> getUserByLogin(String username) {
        return userRepository.getUserByLogin(username);
    }

    public User deleteUserByLogin(String login) {
        return userRepository.deleteUserByLogin(login).orElseThrow();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

}
