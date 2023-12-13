package laoreProjects.IRTiBE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class IrTiBeApplication {

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

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/*").allowedOrigins("http://localhost:4200").allowedMethods("PUT", "DELETE", "GET", "POST", "OPTIONS")
//						.exposedHeaders("Authorization");
//			}
//		};
//	}
}
