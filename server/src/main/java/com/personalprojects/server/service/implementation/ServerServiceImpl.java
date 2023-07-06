package com.personalprojects.server.service.implementation;

import com.personalprojects.server.enumeration.Status;
import com.personalprojects.server.model.Server;
import com.personalprojects.server.repository.ServerRepository;
import com.personalprojects.server.service.ServerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j//Logging
public class ServerServiceImpl implements ServerService {
    private final ServerRepository serverRepository;

    @Override
    public Server create(Server server) {
        log.info("Salvataggio server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepository.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging dell'IP server: {}", ipAddress);
        Server server = serverRepository.findByipAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Recupero i server");
        return serverRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Recupero il server, ID: {}", id);
        return serverRepository.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Aggiornamento server: {}", server.getName());
        return serverRepository.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Eliminazione server, ID: {}", id);
        serverRepository.deleteById(id);
        return Boolean.TRUE;
    }

    private String setServerImageUrl() {
        String[] imageNames = {"server1.png", "server2.png", "server3.png", "server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[new Random().nextInt(4)]).toUriString();
    }
}
