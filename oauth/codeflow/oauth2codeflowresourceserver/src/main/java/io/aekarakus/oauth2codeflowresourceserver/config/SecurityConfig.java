package io.aekarakus.oauth2codeflowresourceserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth
                        .anyRequest().authenticated()
        ).oauth2ResourceServer(
                rs -> rs
                        .jwt(
                                jwt -> jwt.jwkSetUri("http://localhost:5025/oauth2/jwks")
                        )
        );
        return http.build();
    }
}
