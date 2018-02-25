package com.bala.pizza.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
 
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    	//TODO: password hashing and strong 
    	auth
		.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ADMIN");        
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http
		.authorizeRequests()
			//.antMatchers("/pizza/delivery/**").hasRole("ADMIN")			
			.antMatchers("/css/**", "/pizza").permitAll()
			.antMatchers("/js/**", "/pizza/**").permitAll()
			.and()
			.httpBasic();
    }
}