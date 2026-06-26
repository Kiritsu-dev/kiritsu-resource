package kiritsu.resource.subscriptions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.anyRequest().authenticated();
                })
                .oauth2ResourceServer(oath2 -> {
                    oath2.jwt(Customizer.withDefaults());
                })
                .cors(cors -> cors.configurationSource(request -> {
                    var config = new CorsConfiguration();
                    config.setAllowedOrigins(List.of("http://localhost:5173"));
                    config.setAllowedMethods(List.of("GET", "POST", "PATCH"));
                    config.setAllowedHeaders(List.of("*"));
                    return config;
                }))


                .build();
    }
}
