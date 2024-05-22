package io.aekarakus.sssamples.userdetails;

import io.aekarakus.sssamples.userdetails.entities.User;
import io.aekarakus.sssamples.userdetails.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
public class Bootstrapper implements CommandLineRunner {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();
        user1.setId(0L);
        user1.setUserName("Matthew");
        user1.setPassword(passwordEncoder.encode("password"));
        user1.setEmail("matthew@aekarakus.io");

        User user2 = new User();
        user2.setId(1L);
        user2.setUserName("Matthew");
        user2.setPassword(passwordEncoder.encode("password"));
        user2.setEmail("matthew@aekarakus.io");

        repository.saveAll(List.of(user1, user2));
    }
}
