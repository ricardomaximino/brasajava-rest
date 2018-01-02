package com.brasajava.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SpringSecurityConfigure extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/public/**").permitAll()
				.antMatchers("/security/**").hasAnyRole("ADMIN","USER")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and()
				.httpBasic();
		
		http.csrf().disable();
	}  

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("Ricardo Maximino").password("Ricardo2").roles("ADMIN", "USER")
			.and()
				.withUser("user").password("user").roles("USER");
	}
	
	
}
