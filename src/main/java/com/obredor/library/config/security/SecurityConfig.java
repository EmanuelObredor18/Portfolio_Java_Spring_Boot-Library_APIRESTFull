package com.obredor.library.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  // Filtros de seguridad
  // @Bean
  // SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
  //   return httpSecurity
  //       .csrf(csrf -> csrf.disable())
  //       .httpBasic(Customizer.withDefaults())
  //       .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
  //       .authorizeHttpRequests(http -> {
  //         http.requestMatchers(HttpMethod.GET, "/library/api/v1/user/find/all").hasRole("ADMIN");
  //         http.requestMatchers(HttpMethod.GET, "/library/api/v1/user/find").hasAnyAuthority("READ");
  //         http.anyRequest().denyAll();
  //       })
  //       .build();
  // }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
        .csrf(csrf -> csrf.disable())
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
  }

  // Administra la autenticación
  @Bean
  AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
      throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @SuppressWarnings("deprecation")
  PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Bean
  UserDetailsService userDetailsService() {

    List<UserDetails> userDetailsList = new ArrayList<>();

    userDetailsList.add(User
        .withUsername("Emanuel")
        .password("1234")
        .roles("ADMIN")
        .build());

    userDetailsList.add(User
        .withUsername("Javier")
        .password("1234")
        .roles("USER")
        .build());

    return new InMemoryUserDetailsManager(userDetailsList);
  }

  // El encargado de traer los datos de autenticación de la base de datos
  @Bean
  AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder());
    provider.setUserDetailsService(userDetailsService());
    return provider;
  }

}
