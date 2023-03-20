package com.mapping.service.serviceImpl;


import com.mapping.model.dto.UserRegistrationDTO;
import com.mapping.repository.UserRepository;
import com.mapping.service.UserService;
import com.mapping.util.ValidationUtil;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void register(UserRegistrationDTO userRegistrationDTO) {
        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            System.out.println("Wrong password confirmation!");
            return;
        }
        Set<ConstraintViolation<UserRegistrationDTO>> violations = validationUtil.violation(userRegistrationDTO);
        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }

    }
}
