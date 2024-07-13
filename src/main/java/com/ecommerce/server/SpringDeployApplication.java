package com.ecommerce.server;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ecommerce.server.repository")
public class SpringDeployApplication {

    public static void main(String[] args)  {
        SpringApplication.run(SpringDeployApplication.class, args);
    }

}
