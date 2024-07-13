package com.ecommerce.server;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ecommerce.server.repository")
public class SpringDeployApplication {

    public static void main(String[] args) {
        Dotenv dotenv =  Dotenv.configure().directory(System.getProperty("user.home")).load();
        System.setProperty("jwt.secret", dotenv.get("JWT_SECRET"));
        SpringApplication.run(SpringDeployApplication.class, args);
    }

}
