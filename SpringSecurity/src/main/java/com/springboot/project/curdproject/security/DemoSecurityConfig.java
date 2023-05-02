package com.springboot.project.curdproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.FilterChain;

@Configuration
public class DemoSecurityConfig {

    //Adding user , Passwords & their roles
    // by adding details we no need to modify in application.properties file

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        
        UserDetails nayana = User.builder()
                             .username("nayana")
                             .password("{noop}test123")
                             .roles("EMPLOYEE")
                             .build();

        UserDetails pranjal = User.builder()
                             .username("pranjal")
                             .password("{noop}test123")
                             .roles("EMPLOYEE", "MANAGER")
                             .build();
        
        UserDetails rajesh = User.builder()
                             .username("rajesh")
                             .password("{noop}test123")
                             .roles("EMPLOYEE", "MANAGER","ADMIN")
                             .build();

        return new InMemoryUserDetailsManager(nayana, pranjal, rajesh);
                            
    }

    // Restricting access based on roles

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
