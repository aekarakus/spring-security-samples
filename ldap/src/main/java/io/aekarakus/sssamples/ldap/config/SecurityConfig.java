package io.aekarakus.sssamples.ldap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        req -> req.anyRequest().fullyAuthenticated()
                )
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .ldapAuthentication()
                .userDnPatterns("uid={0},cn=users,cn=accounts,dc=aekarakus,dc=io")
                .groupSearchBase("cn=groups")
                .contextSource()
                .url("ldap://freeipa.aekarakus.io/dc=aekarakus,dc=io")
                .and()
                .passwordCompare()
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
