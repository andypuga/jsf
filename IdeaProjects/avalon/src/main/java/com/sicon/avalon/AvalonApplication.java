package com.sicon.avalon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


@SpringBootApplication
public class AvalonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvalonApplication.class, args);
    }


}
