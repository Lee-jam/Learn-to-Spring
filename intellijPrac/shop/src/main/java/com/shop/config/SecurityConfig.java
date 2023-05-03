package com.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
        http.formLogin()
                .loginPage("members/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .failureUrl("/members/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                .logoutSuccessUrl("/");
        http.authorizeRequests().mvcMatchers("/","members/**","/item/**,/images/**").permitAll()
                .mvcMatchers("/admin/**/").hasRole("ADMIN")
                .anyRequest().authenticated();
        return http.build();
    }

}
