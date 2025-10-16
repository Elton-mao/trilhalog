package com.trilhalog.trilhalog.core.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http
	            .csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth
	                    .requestMatchers("/api/public").permitAll()
	                    .anyRequest().permitAll()
	            )
	            .httpBasic(Customizer.withDefaults()) // apenas para teste; em produção use JWT
	            .logout(logout -> logout
	                    .logoutUrl("/auth/logout")
	                    .logoutSuccessHandler((request, response, authentication) -> {
	                        response.setStatus(HttpServletResponse.SC_OK);
	                    })
	                    .invalidateHttpSession(true)
	            )
	            .build();
	}

	
}
