package com.mapping.service;

import com.mapping.model.dto.UserLoginDTO;
import com.mapping.model.dto.UserRegistrationDTO;

public interface UserService {
    void register(UserRegistrationDTO userRegistrationDTO);

    void login(UserLoginDTO userLoginDTO);
}
