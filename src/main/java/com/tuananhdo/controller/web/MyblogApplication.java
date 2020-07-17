package com.tuananhdo.controller.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@ComponentScan("com.tuananhdo")
@EntityScan("com.tuananhdo.entity")
@EnableJpaRepositories("com.tuananhdo.repository")
public class MyblogApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyblogApplication.class, args);
    }


}
