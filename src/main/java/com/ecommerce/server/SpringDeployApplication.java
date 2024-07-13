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

    public static void main(String[] args) throws IOException {
        Dotenv dotenv =  Dotenv.load();
        System.setProperty("jwt.secret",  "dothihuynhnhuxinhtuoinhattrandoiemlahoaluonkhoesacrangngoiemroixaanhkhongthesongemoinenlahaycukebenthoi");
        Path rootDir = Paths.get("/"); // Replace with your root directory path
        String fileNameToFind = ".env"; // Replace with the file name you want to find

        Files.walkFileTree(rootDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().equals(fileNameToFind)) {
                    System.out.println("File found: " + file.toAbsolutePath());
                    return FileVisitResult.TERMINATE; // Terminate search after finding the first occurrence
                }
                else {
                    System.out.println(file.getFileName().toString());
                }
                return FileVisitResult.CONTINUE; // Continue searching
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE; // Continue if access is denied or other errors occur
            }
        });
        SpringApplication.run(SpringDeployApplication.class, args);
    }

}
