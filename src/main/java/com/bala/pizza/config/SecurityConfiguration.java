package com.bala.pizza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Spring Securigy Configuration 
 * @author engan.bala
 *
 */

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
    	//.csrf() is enabled by default
    	http
		.authorizeRequests()
		// security disabled to run the application
		//.antMatchers("/pizza/delivery/**").hasRole("ADMIN")			
			.antMatchers("/css/**", "/pizza").permitAll()
			.antMatchers("/js/**", "/pizza/**").permitAll()
			.antMatchers("/**").permitAll()
			.and()
			.httpBasic()
			.and()
			.csrf();
    }
    
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}