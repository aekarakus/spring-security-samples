package io.aekarakus.sssamples.jdbcuserdetails;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Bootstrapper implements CommandLineRunner {
    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.update(
                "INSERT INTO users VALUES (?, ?, ?)", "alice", passwordEncoder.encode("password"), true
        );

        jdbcTemplate.update(
                "INSERT INTO users VALUES (?, ?, ?)", "robert", passwordEncoder.encode("password"), true
        );

        jdbcTemplate.update(
                "INSERT INTO authorities VALUES (?, ?)", "robert", "ROLE_ADMIN"
        );

//        create table authorities (username varchar_ignorecase(50) not null,authority varchar_ignorecase(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
    }
}
