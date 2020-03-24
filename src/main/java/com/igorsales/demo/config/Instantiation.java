package com.igorsales.demo.config;

import com.igorsales.demo.domain.User;
import com.igorsales.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User jose = new User(null, "Jose Carlos","josecarlos@gmail.com","(83)1234-5678");
        User igor = new User(null, "Igor Sales","igorsales.fs@gmail.com", "(83)99999-9999");
        User carlos = new User(null, "Carlos Alberto","carlos@gmail.com", "(00)90000-0000");

        userRepository.saveAll(Arrays.asList(jose, igor, carlos));
    }
}
