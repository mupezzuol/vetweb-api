package com.vetweb.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationService authenticationService;// Implements: UserDetailsService

	
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	
	// Authentication Settings (access control, login etc...)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(authenticationService)
			.passwordEncoder(encoder());
	}

	
	// Authorization Settings (URL's, who can access the URL, access profile etc...)
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
				.disable()
			.csrf()
				.disable()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.GET, "/").permitAll()//Home
					.antMatchers(HttpMethod.POST, "/auth").permitAll()//Login
					.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
				.anyRequest()
					.authenticated()
			.and()
				.addFilterBefore(new JWTLoginFilter("/auth", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new JWTAuthenticationVerifier(), UsernamePasswordAuthenticationFilter.class);
	}

	
	// Static resource settings (CSS, JS, Images etc...)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
	}
	
	
	//Roles for Encoder
	@Bean
	public PasswordEncoder encoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}

	
}
