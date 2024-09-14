package com.example.Splitwise.controllers;

import com.example.Splitwise.dtos.RegisterUserRequestDTO;
import com.example.Splitwise.dtos.RegisterUserResponseDTO;
import com.example.Splitwise.models.User;
import com.example.Splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    public RegisterUserResponseDTO registerUser(RegisterUserRequestDTO registerUserRequestDTO) {
        User user = userService.registerUser(registerUserRequestDTO.getUsername(), registerUserRequestDTO.getPhoneNumber(), registerUserRequestDTO.getPassword());
        return RegisterUserResponseDTO.RegisterUser(user);
    }
}
