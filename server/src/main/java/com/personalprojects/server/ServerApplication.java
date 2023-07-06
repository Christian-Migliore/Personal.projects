package com.personalprojects.server;

import com.personalprojects.server.enumeration.Status;
import com.personalprojects.server.model.Server;
import com.personalprojects.server.repository.ServerRepository;
import jakarta.servlet.FilterRegistration;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.util.Arrays;


@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepository serverRepository){
		return args -> {
			serverRepository.save(new Server(null, "192.168.1.129", "Ubuntu Linux", "16 GB", "Personal PC", "http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
			serverRepository.save(new Server(null, "192.168.1.32", "Fedora Linux", "16 GB", "Dell tower", "http://localhost:8080/server/image/server2.png", Status.SERVER_DOWN));
			serverRepository.save(new Server(null, "192.168.1.90", "MS 2008", "32 GB", "Web Server", "http://localhost:8080/server/image/server3.png", Status.SERVER_UP));
			serverRepository.save(new Server(null, "192.168.1.71", "Red Hat Enterprise Linux", "64 GB", "Mail Server", "http://localhost:8080/server/image/server4.png", Status.SERVER_DOWN));
		};
	}


	//Configurazioni/autorizzazioni di base
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://Localhost:3000",
				"http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")) ;
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return urlBasedCorsConfigurationSource;
	}

}
