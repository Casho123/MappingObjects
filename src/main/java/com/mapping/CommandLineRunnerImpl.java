package com.mapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        while(true) {
            System.out.println("Enter your commands:");
            String[] commands = bufferedReader.readLine().split("\\s+");

            String command = commands[0];

            switch (command) {

            }
        }
    }
}
