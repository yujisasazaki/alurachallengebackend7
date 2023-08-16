package br.com.akrasia.alurachallengebackend7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Alurachallengebackend7Application {

	public static void main(String[] args) {
		SpringApplication.run(Alurachallengebackend7Application.class, args);
	}

    @Bean
    public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				System.out.println("corsConfigurer");
				registry.addMapping("/**")
					.allowedOrigins("http://localhost:8080");
			}
		};
	}

}
