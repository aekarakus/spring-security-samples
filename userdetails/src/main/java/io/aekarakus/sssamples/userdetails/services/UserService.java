package io.aekarakus.sssamples.userdetails.services;

import io.aekarakus.sssamples.userdetails.entities.CustomUserDetails;
import io.aekarakus.sssamples.userdetails.entities.User;
import io.aekarakus.sssamples.userdetails.repositories.UserRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Data
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("A user with specified user name does not exist."));
        return new CustomUserDetails(user);
    }
}
