package com.hk.exceptionhandling.service;

import com.hk.exceptionhandling.entity.User;
import com.hk.exceptionhandling.exception.ResourceAlreadyExistsException;
import com.hk.exceptionhandling.exception.ResourceNotFoundException;
import com.hk.exceptionhandling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public String createUser(User user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new ResourceAlreadyExistsException("User already exist with Mail: " + user.getEmail());
        }
        userRepo.save(user);
        return "SUCCESS";
    }

    public User getUserById(int userId) {
        return userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public ResponseEntity<?> deleteUser(int userId) {
        if (userRepo.findById(userId).isPresent()) {
            userRepo.deleteById(userId);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }

        throw new ResourceNotFoundException("User not found with id: " + userId);
    }
}
