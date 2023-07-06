package com.personalprojects.usersSystem.controller;

import com.personalprojects.usersSystem.model.User;
import com.personalprojects.usersSystem.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServiceImpl userService;
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user){
         userService.addNewUser(user);
    }
    @DeleteMapping(path = "{userId}")
    public void deleteUser(
                @PathVariable("userId") int userId){
        userService.deleteUser(userId);
    }

    @PutMapping("{userId}")
    public void updateUser(@PathVariable("userId") int userId,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String password){
        userService.updateUser(userId, email, password);
        System.out.println("aggiornamento");
    }
}
