package com.ust.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public static PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http.authorizeHttpRequests(registry -> {
		registry.requestMatchers("/").permitAll();
		registry.requestMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN");
		registry.requestMatchers("/user/**").hasAnyAuthority("ROLE_USER");
		registry.anyRequest().authenticated();
		}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll).build();
		
	}
	

//	@Bean
//	InMemoryUserDetailsManager userDetailsService() {
//		UserDetails userDetails = User.builder()
//										.username("bean")
//										.password(PasswordEncoder().encode("mister"))
//										.roles("USER")
//										.build();
//		UserDetails adminDetails = User.builder()
//										.username("bond")
//										.password(PasswordEncoder().encode("james"))
//										.roles("ADMIN")
//										.build();
//		return new InMemoryUserDetailsManager(userDetails,adminDetails);
//	}
}
