package com.example.relaxer.config;

import com.example.relaxer.entity.Credentials;

import com.example.relaxer.repositories.CredentialsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtUtils jwtUtils() {
        return new JwtUtils();
    }

    @Bean
    public UserDetailsService userDetailsService(CredentialsRepository credentialsRepository) {
        return username -> {
            Credentials credentials = credentialsRepository.findByUserName(username)
                    .orElseThrow(() -> new UsernameNotFoundException(username));
            return org.springframework.security.core.userdetails.User
                    .builder()
                    .username(credentials.getUsername())
                    .password(credentials.getPassword())
                    .roles(credentials.getRole().getName().replace("ROLE_", ""))
                    .build();
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           JwtUtils jwtUtils,
                                           CredentialsRepository credentialsRepository) throws Exception {
        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(jwtUtils, userDetailsService(credentialsRepository));

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/register", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources", "/webjars").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}