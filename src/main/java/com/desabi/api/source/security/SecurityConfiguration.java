package com.desabi.api.source.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    private static final String URL_BASE = "/api-source";
    private static final String URL_PERSON= URL_BASE+"/person";
    private static final String URL_PERSON_ID = URL_PERSON+"/{id}";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authz -> authz.anyRequest().denyAll());
        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .antMatchers(HttpMethod.GET, URL_BASE)
                .antMatchers(HttpMethod.POST, URL_PERSON)
                .antMatchers(HttpMethod.GET, URL_PERSON)
                .antMatchers(HttpMethod.GET, URL_PERSON_ID)
                .antMatchers(HttpMethod.PUT, URL_PERSON_ID)
                .antMatchers(HttpMethod.DELETE, URL_PERSON_ID);
    }
}
