package com.example.Splitwise.commands;

import com.example.Splitwise.controllers.UserController;
import com.example.Splitwise.dtos.RegisterUserRequestDTO;
import com.example.Splitwise.dtos.RegisterUserResponseDTO;
import com.example.Splitwise.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserCommand implements Command{

    public static final String REGISTER_USER_COMMAND = "Register";
    private final UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
        CommandRegistry.getInstance().addCommand(REGISTER_USER_COMMAND, this);
    }

    @Override
    public void execute(String input) {
        String[] split = input.split(" ");
        if(ValidateCommand(split)) {
            String username = split[1];
            String phoneNumber = split[2];
            String password = split[3];
            RegisterUserRequestDTO registerUserRequestDTO = new RegisterUserRequestDTO();
            registerUserRequestDTO.setUsername(username);
            registerUserRequestDTO.setPhoneNumber(phoneNumber);
            registerUserRequestDTO.setPassword(password);

            RegisterUserResponseDTO dto = userController.registerUser(registerUserRequestDTO);
            System.out.println(dto);
        }
        else {
            throw new RuntimeException("Incorrect Register user command, please look at syntax");
        }
    }

    public boolean ValidateCommand(String[] split) {
        return split.length == 4 && split[0].equals(REGISTER_USER_COMMAND);
    }
}
