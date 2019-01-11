package com.droidinfotech;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//https://github.com/springframeworkguru/springbootwebapp/tree/springboot-mysql/src/main/java/guru/springframework
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
