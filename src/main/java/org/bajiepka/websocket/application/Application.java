package org.bajiepka.websocket.application;

import org.bajiepka.websocket.application.configuration.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Bean
    public AnnotationConfigApplicationContext context() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ApplicationConfig.class);
        ctx.refresh();
        return ctx;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
