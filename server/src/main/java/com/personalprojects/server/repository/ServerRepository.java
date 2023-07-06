package com.personalprojects.server.repository;

import com.personalprojects.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {
    Server findByipAddress(String ipAddress);


}
