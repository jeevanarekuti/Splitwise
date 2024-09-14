package com.example.Splitwise.services;

import com.example.Splitwise.models.User;
import com.example.Splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String username, String PhoneNumber, String password) {
        User user = new User();
        user.setName(username);
        user.setPhoneNumber(PhoneNumber);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        user.setPassword(encode);
        return this.userRepository.save(user);
    }
}
