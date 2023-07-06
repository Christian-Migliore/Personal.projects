package com.personalprojects.usersSystem.config;

import com.personalprojects.usersSystem.model.User;
import com.personalprojects.usersSystem.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            User root = new User(
                    "cmigliore19@gmail.com",
                    "root"
            );

            User admin = new User(
                    "admin.email@gmail.com",
                    "admin"
            );

            User alex = new User(
                    "alex.user@gmail.com",
                    "ciao"
            );

            userRepository.saveAll(
                    List.of(root, admin, alex)
            ); 
        };

    }
}
