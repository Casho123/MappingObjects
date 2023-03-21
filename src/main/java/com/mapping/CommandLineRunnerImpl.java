package com.mapping;

import com.mapping.model.dto.UserLoginDTO;
import com.mapping.model.dto.UserRegistrationDTO;
import com.mapping.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final UserService userService;

    public CommandLineRunnerImpl(UserService userService) {
        this.userService = userService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            System.out.println("Enter your commands:");
            String[] commands = bufferedReader.readLine().split("\\|");

            String command = commands[0];

            switch (command) {
                case "RegisterUser":
                    this.userService.register(new UserRegistrationDTO(commands[1], commands[2], commands[3], commands[4]));
                    break;
                case "LoginUser":
                    this.userService.login(new UserLoginDTO(commands[1], commands[2]));
            }
        }
    }
}
