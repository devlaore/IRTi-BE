package laoreProjects.IRTiBE.authentication.configuration;

import laoreProjects.IRTiBE.authentication.jwtElements.JWTFilterAuthentication;
import laoreProjects.IRTiBE.authentication.jwtElements.JWTUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class AuthenticationConfiguration {

    private final JWTUserDetailsManager jwtUserDetailsManager;
    private final JWTFilterAuthentication jwtFilterAuthentication;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return
                http
                .csrf(AbstractHttpConfigurer::disable)
                //.csrf(csrf -> csrf.disable())

                //.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
                //.cors(Customizer.withDefaults())

                .authorizeHttpRequests((authorize) -> authorize

                        .requestMatchers("/authentication/login").permitAll()
                        .anyRequest().authenticated()
                        //.anyRequest().permitAll()


                    //.requestMatchers("/**").permitAll()
                    //.anyRequest().authenticated()
                )


                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtFilterAuthentication, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
        // AuthenticationProvider for user and password authentication
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(jwtUserDetailsManager);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    AuthenticationManager authenticationManager(org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
