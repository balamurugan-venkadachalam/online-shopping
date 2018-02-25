package com.bala.pizza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    	//TODO: password hashing and strong 
		auth.jdbcAuthentication()
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("sql...")
		.authoritiesByUsernameQuery("sql...");    
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//TODO: Enable valid url  
    	http
		.authorizeRequests()
			//.antMatchers("/pizza/delivery/**").hasRole("ADMIN")			
			//.antMatchers("/css/**", "/pizza").permitAll()
			//.antMatchers("/js/**", "/pizza/**").permitAll()
			.antMatchers("/**").permitAll()
			.and()
			.httpBasic();
    }
    
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}