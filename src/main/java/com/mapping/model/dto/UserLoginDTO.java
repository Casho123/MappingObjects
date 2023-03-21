package com.mapping.model.dto;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;

public class UserLoginDTO {
    @Email(message = "Enter valid email.")
    private String email;
    @Pattern(regexp = "[A-Za-z\\d]{6,}",
    message = "Enter your valid password.")
    private String password;

    public UserLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserLoginDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
