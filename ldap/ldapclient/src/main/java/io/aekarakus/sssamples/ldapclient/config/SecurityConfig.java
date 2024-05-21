package io.aekarakus.sssamples.ldapclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.ldap.LdapPasswordComparisonAuthenticationManagerFactory;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

@Configuration
public class SecurityConfig {

    @Bean
    ContextSource contextSource() {
        return new DefaultSpringSecurityContextSource("ldap://localhost:33389/dc=springframework,dc=org");
    }

    @Bean
    AuthenticationManager authenticationManager(BaseLdapPathContextSource contextSource) {
        LdapPasswordComparisonAuthenticationManagerFactory factory = new LdapPasswordComparisonAuthenticationManagerFactory(contextSource, NoOpPasswordEncoder.getInstance());
        factory.setUserDnPatterns("uid={0},ou=people");
        factory.setPasswordAttribute("userPassword");
        return factory.createAuthenticationManager();
    }
}
