package com.projet.backend.security;



import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth

	            .requestMatchers("/api/books/**").hasAnyRole("USER", "ADMIN")

	            .requestMatchers("/api/loans/**").hasAnyRole("USER", "ADMIN")

	            .requestMatchers("/api/admin/**").hasRole("ADMIN")

	            .anyRequest().authenticated()
	        )

	        .httpBasic(Customizer.withDefaults());

	    return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}