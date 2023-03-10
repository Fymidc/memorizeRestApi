package com.example.englishapp.auth.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	   @Bean
	    public SecurityFilterChain filter(HttpSecurity http)throws Exception{
		   http
		   	.cors()
		   	.and()
		   	.csrf().disable()
		   	.authorizeRequests()
		   .anyRequest().permitAll();
		   /*
	         .anyRequest().authenticated()
	         .and()
	         .oauth2Login();
		   */
	    	return http.build();
	    }
	
}
