package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"app.controller","app.service","app.dao"})
public class BootMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMongoApplication.class, args);
	}
}
