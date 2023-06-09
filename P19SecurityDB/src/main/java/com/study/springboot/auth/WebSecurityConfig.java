package com.study.springboot.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.DispatcherType;



@Configuration

public class WebSecurityConfig {
	
	@Autowired
	public AuthenticationFailureHandler authFailHandler;
	
	@Autowired
	public AuthenticationSuccessHandler successHandler;
	
	@Bean
	   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	      http.csrf().disable().cors().disable();
	      http.authorizeHttpRequests(request -> request.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
	            .requestMatchers("/").permitAll()
	            .requestMatchers("/css/**","/js/**","/img/**").permitAll()
	            .requestMatchers("/guest/**").permitAll()
	            .requestMatchers("/member/**").hasAnyRole("USER","ADMIN")
	            .requestMatchers("/admin/**").hasRole("ADMIN")
	            .anyRequest().authenticated());
	      http.formLogin()
	      .loginPage("/loginForm") //default : /login
	      .loginProcessingUrl("/j_spring_security_check")
	      //.failureUrl("/loginError")
	      //.failureUrl("/loginForm?error")
	      .failureHandler(authFailHandler)
	      //.defaultSuccessUrl("/")
	      //.successForwardUrl("/forward")
	      .successHandler(successHandler)
	      .usernameParameter("j_username")
	      .passwordParameter("j_password")
	      .permitAll();
	      http.logout()
	      .logoutUrl("/logout")
	      .logoutSuccessUrl("/loginForm")
	      .permitAll();
	      return http.build();
	   }
	@Bean
	public UserDetailsManager users(DataSource datasource) {
		System.out.println(PasswordEncoder().encode("1234"));
		JdbcUserDetailsManager users
					= new JdbcUserDetailsManager(datasource);
		users.setUsersByUsernameQuery("select name as userName,password"
				+ " ,enabled from user_list where name=? ");
		users.setAuthoritiesByUsernameQuery("select name as userName, "
				+ " authority from user_list where name=? ");
		return users;
		
	}
//	@Bean
//	public InMemoryUserDetailsManager userDetailService() {
//		UserDetails user = User.withUsername("user").password(PasswordEncoder().encode("1234")).roles("USER").build();
//		UserDetails admin = User.withUsername("admin").password(PasswordEncoder().encode("1234")).roles("ADMIN").build();
//		UserDetails[] userDetails = new UserDetails[2];
//		userDetails[0]=user;
//		userDetails[1]=admin;
//		System.out.println(">> ");
//		System.out.println(PasswordEncoder().encode("1234"));
//		System.out.println(" << ");
//		return new InMemoryUserDetailsManager(userDetails);
//	}
	@Bean
	public BCryptPasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
		//StandardPasswordEncoder()-SHA256
		//NoOpPasswordEncoder()-암호화하지 않은 데이터
	}
	
}
