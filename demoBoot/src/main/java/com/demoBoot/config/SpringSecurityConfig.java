package com.demoBoot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.demoBoot.service.UserPasswordService;

@Configurable
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserPasswordService userService;
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	@Autowired
	private InvalidUserAuthEntryPoint authEntryPoint;

	private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
           "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // other public endpoints of your API may be appended to this array
    };
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		   .csrf().disable()
		   .authorizeRequests()
		   .antMatchers(AUTH_WHITELIST).permitAll()
		//  .antMatchers("/v2/user/addClient").permitAll()
		   .antMatchers("/v2/user/**").permitAll()		   
		   .anyRequest().authenticated()
		   .and()
		   .exceptionHandling()
		   .authenticationEntryPoint(authEntryPoint)
		   .and()
		   .sessionManagement()
		   .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		   .and()
		   
		   //Register filter for 2nd request onwards
		  .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).formLogin();
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("bunny").password(pc().encode("singh")).roles("ADMIN");

		auth.userDetailsService(userService).passwordEncoder(pc());

	}

	@Bean
	public BCryptPasswordEncoder pc() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationManager manager() throws Exception {
		
		return super.authenticationManager();
	}
	
}
