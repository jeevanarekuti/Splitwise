package com.example.Splitwise.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class User extends BaseModel{
    private String name;
    private String phoneNumber;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", PhoneNumber='" + phoneNumber + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
