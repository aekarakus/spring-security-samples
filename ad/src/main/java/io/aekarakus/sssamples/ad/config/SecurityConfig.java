package io.aekarakus.sssamples.ad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

@Configuration
public class SecurityConfig {

    @Bean
    ActiveDirectoryLdapAuthenticationProvider  activeDirectoryLdapAuthenticationProvider(){
        return new ActiveDirectoryLdapAuthenticationProvider("aekarakus.io", "ldap://aekarakus.io");
    }
}
