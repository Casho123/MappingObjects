package com.mapping.model.dto;

import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegistrationDTO {

    @Email(message = "Enter a valid email")
    private String email;
    @Pattern(regexp = "[A-Za-z\\d]{6,}",
    message = "Invalid input! Password must be more than 6 symbols long.")
    private String password;
    private String confirmPassword;
    @Size(min=2, max = 50)
    private String name;

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String email, String password, String confirmPassword, String name) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.name = name;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

