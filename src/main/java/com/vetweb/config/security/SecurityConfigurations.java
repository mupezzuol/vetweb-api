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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.vetweb.repositories.IUserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationService authenticationService;//Implements: UserDetailsService
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private IUserRepository userRepository;
	
	
	// Manual dependency injection
	@Override
	@Bean 
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	
	// Authentication Settings (access control, login etc...)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	// Authorization Settings (URL's, who can access the URL, access profile etc...)
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/v1/user").permitAll()
			.antMatchers(HttpMethod.POST, "/v1/clinic").permitAll()
			.antMatchers(HttpMethod.POST, "/auth").permitAll()//Login
			.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)//Set Stateless
			
			//Pass created Token filter
			.and().addFilterBefore(
					new AuthenticationTokenFilter(tokenService, userRepository),
					UsernamePasswordAuthenticationFilter.class);
	}
	
	
	//Static resource settings (CSS, JS, Images etc...)
	@Override
	public void configure(WebSecurity web) throws Exception {
		// Release addresses for Swagger
		web.ignoring()
			.antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
	}
	
	
}
