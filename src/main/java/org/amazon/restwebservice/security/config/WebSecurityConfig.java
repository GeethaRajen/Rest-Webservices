package org.amazon.restwebservice.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	/**
	 * Get the details of user has access to APIs
	 * @return
	 */
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails user = User.builder()
							.username("user")
							.password(passwordEncoder().encode("12345"))
							.roles("USER").build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * HTTP Basic Authentication for REST Webservices
	 * */
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.authorizeHttpRequests(request -> request
												.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.csrf(AbstractHttpConfigurer::disable)
				.build();
	}
}