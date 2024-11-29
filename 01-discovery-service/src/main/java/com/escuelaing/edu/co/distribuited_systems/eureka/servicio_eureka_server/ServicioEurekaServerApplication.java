package com.escuelaing.edu.co.distribuited_systems.eureka.servicio_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServicioEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioEurekaServerApplication.class, args);
    }

}
