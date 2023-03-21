package com.mapping.service.serviceImpl;


import com.mapping.model.dto.UserLoginDTO;
import com.mapping.model.dto.UserRegistrationDTO;
import com.mapping.model.entity.User;
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
    private User loggedInUser;

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
            return;
        }
        User user  = modelMapper.map(userRegistrationDTO, User.class);

        this.userRepository.save(user);
        System.out.println(user.getFullName() + " was registered");

    }

    @Override
    public void login(UserLoginDTO userLoginDTO) {
        User user = this.userRepository.findByEmailAndPassword(userLoginDTO.getEmail(), userLoginDTO.getPassword()).orElse(null);

        if (user == null) {
            System.out.println("Incorrect username / password");
            return;
        }

        loggedInUser = user;
        System.out.println("Successfully logged in " + user.getFullName());

    }

    @Override
    public void logout() {
        if (loggedInUser == null) {
            System.out.println("Cannot log out. No user was logged in.");
            return;
        }
        String name = loggedInUser.getFullName();
        loggedInUser = null;
        System.out.printf("User %s successfully logged out\n", name);

    }
}
