package com.example.Splitwise.dtos;

import com.example.Splitwise.models.User;
import lombok.Data;

@Data
public class RegisterUserResponseDTO {
    String username;
    String phoneNumber;

    public static RegisterUserResponseDTO RegisterUser(User user) {
        RegisterUserResponseDTO registerUserResponseDTO = new RegisterUserResponseDTO();
        registerUserResponseDTO.setUsername(user.getName());
        registerUserResponseDTO.setPhoneNumber(user.getPhoneNumber());
        return registerUserResponseDTO;
    }

    @Override
    public String toString() {
        return "RegisterUserResponseDTO{" +
                "username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
