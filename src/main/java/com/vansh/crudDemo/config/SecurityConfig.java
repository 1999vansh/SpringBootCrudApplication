package com.vansh.crudDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Class for implementing Spring Security for our application
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    // Method to define user or list of user that are allowed for Authentication
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles("USER")
                .and()
                .withUser("vansh")
                .password("vansh123")
                .roles("ADMIN");
    }

    // Method to define how Password will be stored
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //Method to define which user can access which API (Authorization)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/courses/").hasRole("USER")
//                .antMatchers("/courses/{id}").hasAnyRole("USER","ADMIN")
//                .antMatchers("/courses/{id}").permitAll()
                .antMatchers("/courses/**").permitAll()
                .and().formLogin();
    }
}
