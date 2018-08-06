package com.abharatha.LearningSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "models", "resource", "service" })
@EntityScan("entity")
@EnableJpaRepositories("dao")
public class LearningSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringBootApplication.class, args);
		// ConfigurableApplicationContext ctx = new SpringApplicationBuilder(hi.class)
		// .headless(false).web(false).run(args);
	}

}
