package io.aekarakus.sssamples.jdbcuserdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class JdbcUserDetailsApplication {
    public static void main( String[] args ){
        SpringApplication.run(JdbcUserDetailsApplication.class, args);
    }
}
