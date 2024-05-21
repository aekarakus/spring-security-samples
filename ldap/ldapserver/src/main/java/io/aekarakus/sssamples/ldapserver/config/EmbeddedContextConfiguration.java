package io.aekarakus.sssamples.ldapserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;

@Configuration
public class EmbeddedContextConfiguration {

    /*
    * Builds a minimum ldap server with dn: dc=springframework,dc=org
    * Note: with this configuration user.ldif does not work for some reason.
    * */
    @Bean
    public EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean() {
        return EmbeddedLdapServerContextSourceFactoryBean.fromEmbeddedLdapServer();
    }
}
