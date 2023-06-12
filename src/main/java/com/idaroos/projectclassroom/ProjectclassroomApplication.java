package com.idaroos.projectclassroom;

import com.idaroos.projectclassroom.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectclassroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectclassroomApplication.class, args);
    }

//    User testUser = new User("Bob", "Bobson", "Bob@example.com", "1234", "Bobgatan 4");

}
