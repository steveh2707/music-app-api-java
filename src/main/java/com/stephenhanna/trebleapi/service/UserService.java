package com.stephenhanna.trebleapi.service;

import com.stephenhanna.trebleapi.entity.User;
import com.stephenhanna.trebleapi.model.request.UserRequest;
import com.stephenhanna.trebleapi.repository.UserRepository;
import com.stephenhanna.trebleapi.service.exception.EmailAlreadyExistsException;
import com.stephenhanna.trebleapi.service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            throw new ResourceNotFoundException("User not found.");
        }

        return user;
    }

    public void addNewUser(UserRequest userRequest) {
        Optional<User> userWithEmail = userRepository.findUserByEmail(userRequest.getEmail());

        if (userWithEmail.isPresent()) {
            throw new EmailAlreadyExistsException();
        }

        User user = new User(userRequest);

        userRepository.save(user);
    }

}
