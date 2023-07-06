package com.personalprojects.server.controller;

import com.personalprojects.server.enumeration.Status;
import com.personalprojects.server.model.Response;
import com.personalprojects.server.model.Server;
import com.personalprojects.server.service.ServerService;
import com.personalprojects.server.service.implementation.ServerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.util.MimeTypeUtils.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerController {
    private final ServerServiceImpl serverService;


    @GetMapping("/list")
    public ResponseEntity<Response> getServers(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map .of("servers", serverService.list(30)))
                        .message("Server recuperati")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }


    @GetMapping("/ping/{ipAddress}")
    public ResponseEntity<Response> pingServer(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Server server = serverService.ping(ipAddress);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("server", server))
                        .message(server.getStatus() == Status.SERVER_UP ? "Ping avvenuto con successo." : "Ping fallito.")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }


    @PostMapping("/save")
    public ResponseEntity<Response> saveServer(@RequestBody @Valid Server server) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("server", serverService.create(server)))
                        .message("Server creato.")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getServer(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("server", serverService.get(id)))
                        .message("Server recuperato.")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<Response> deleteServer(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("eliminato", serverService.delete(id)))
                        .message("Server eliminato.")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }


    @GetMapping(value = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getServerImage(@PathVariable("fileName") String fileName) throws IOException  {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/Downloads/images/" + fileName));
    }


}
