package io.aekarakus.sssamples.ad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

@Configuration
public class SecurityConfig {

    @Bean
    ActiveDirectoryLdapAuthenticationProvider  activeDirectoryLdapAuthenticationProvider(){
        return new ActiveDirectoryLdapAuthenticationProvider("aekarakus.io", "ldap://aekarakus.io");
    }
}
