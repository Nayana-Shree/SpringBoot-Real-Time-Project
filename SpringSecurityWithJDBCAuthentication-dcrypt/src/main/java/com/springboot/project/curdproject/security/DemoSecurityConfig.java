package com.springboot.project.curdproject.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.FilterChain;

@Configuration
public class DemoSecurityConfig {

    // add support for JDBC authentication for users and their roles

    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource){

        return new JdbcUserDetailsManager(datasource);

        
    }

    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->configurer
                                  .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                                  .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                                  .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                                  .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                                  .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );

        //use HTTP Basic Authentications
        http.httpBasic();

        //disable Cross Site Request Forgery(CSRF)
        http.csrf().disable();

        return http.build();
    }

    
}
