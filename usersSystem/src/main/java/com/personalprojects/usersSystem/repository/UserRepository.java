package com.personalprojects.usersSystem.repository;

import com.personalprojects.usersSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Integer> {

//    SELECT * FROM User WHERE email= ?
//    @Query("SELECT u FROM User u WHERE u.email = 1?")
     Optional<User> findUserByEmail(String email);
}
