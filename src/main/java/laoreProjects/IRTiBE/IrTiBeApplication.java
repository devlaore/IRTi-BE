package laoreProjects.IRTiBE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//public class IrTiBeApplication  extends SpringBootServletInitializer {		// DECOMMENTARE per doploy in server produzione
public class IrTiBeApplication {
//
	public static void main(String[] args) {
		SpringApplication.run(IrTiBeApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/anagrafiche/**")
						.allowedOrigins("http://localhost:8210");

				registry.addMapping("/dds/**")
						.allowedOrigins("http://localhost:8210")
						//.allowedHeaders("*")
						.allowedMethods("GET","POST","PATCH", "PUT", "DELETE", "OPTIONS", "HEAD")
						//.allowCredentials(true).maxAge(3600)
						//.exposedHeaders("Authorization")
				;

				registry.addMapping("/authentication/**")
						.allowedOrigins("http://localhost:8210");


			}
		};
	}


	/*
		DECOMMENTARE per doploy in server produzione
	 */
/*	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(IrTiBeApplication.class);
	}*/
}
