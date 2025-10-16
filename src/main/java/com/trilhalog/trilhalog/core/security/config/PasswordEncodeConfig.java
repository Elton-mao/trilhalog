package com.trilhalog.trilhalog.core.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncodeConfig {
	
	@Bean
	PasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}
}
