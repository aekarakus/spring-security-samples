package io.aekarakus.oauth2pkceresourceserver.config;

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
                                jwt -> jwt.jwkSetUri("http://localhost:5035/oauth2/jwks")
                        )
        );
        return http.build();
    }


    /*
        we are going to get authentication from authserver, no need for these!
     */

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults())
//        ;
//        return http.build();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder){
//
//        UserDetails john = User.withUsername("john")
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .authorities("ROLE_MANAGER")
//                .disabled(false)
//                .password(passwordEncoder.encode("password"))
//                .username("john")
//                .build();
//
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        inMemoryUserDetailsManager.createUser(john);
//
//        return inMemoryUserDetailsManager;
//    }
}
