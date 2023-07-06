package com.personalprojects.usersSystem.service;

import com.personalprojects.usersSystem.model.User;
import com.personalprojects.usersSystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


//    **** Methods ****
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository
                .findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("Email già presente.");
        }
        userRepository.save(user);
    }

    public void deleteUser(int userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("L'utente con id: " + userId + " non esiste.");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(int userId, String email, String password) {
        System.out.println("step 1");
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "L'utente con id: " + userId + " non esiste."));

        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(user.getEmail(), email)){
            System.out.println("email cambiata");

            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if(userOptional.isPresent()){
                throw new IllegalStateException("Email già presente.");
            }
            user.setEmail(email);
        }

        if(password != null &&
                password.length() > 0 &&
                !Objects.equals(user.getPassword(), password)){
            System.out.println("password cambiata");
            user.setPassword(password);
        }
    }

}
