package com.dizzy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		/**
		 * Below is the custom security configurations
		 */

        http.authorizeHttpRequests()
                        .requestMatchers("/myAccount").authenticated()
                        .requestMatchers("/myBalance",
                        		"/encodePass/**","/v3/api-docs/**","/swagger-ui/**"
).permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();
	}
	
	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean public NoOpPasswordEncoder passwordEncoder() { return
	 * (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	 * 
	 * }
	 */
	

	
	 @Bean 
	 public PasswordEncoder passwordEncoder() 
	 { 
		 return new	 BCryptPasswordEncoder(); 
		 }
	 
	 

}
