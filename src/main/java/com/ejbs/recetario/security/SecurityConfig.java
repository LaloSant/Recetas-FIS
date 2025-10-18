package com.ejbs.recetario.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ejbs.recetario.service.UsuarioServiceImpl;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

	@Autowired
	private final UsuarioServiceImpl usuarioServiceImpl;

	@Bean
	public UserDetailsService userDetailsService(){
		return usuarioServiceImpl;
	}

	@Bean
	public AuthenticationProvider authenticationProvider(){
		return new DaoAuthenticationProvider(userDetailsService());
	}

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
		return httpSecurity
			.csrf(AbstractHttpConfigurer::disable)
			.formLogin(httpForm -> {
				httpForm
					.loginPage("/login").permitAll();
			})
			.authorizeHttpRequests(registry -> {
				registry.requestMatchers("/registro", "/css/**", "/img/**").permitAll();
				registry.anyRequest().authenticated();
			})
			.build();
	}
}
