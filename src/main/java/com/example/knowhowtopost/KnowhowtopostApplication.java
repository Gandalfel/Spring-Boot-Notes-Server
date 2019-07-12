package com.example.knowhowtopost;

import com.example.knowhowtopost.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class KnowhowtopostApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowhowtopostApplication.class, args);
    }

}
