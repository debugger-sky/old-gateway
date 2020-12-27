package com.msa.gateway.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SkyTest2WebConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.httpBasic()
                .and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/login/**", "/other/**").permitAll()
                .antMatchers("/hello/**").denyAll()
                .and().formLogin().permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().build();

    }



}
