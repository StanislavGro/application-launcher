package com.launcher.api.configuration;

import com.launcher.api.service.auth.ExternalUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.AbstractJackson2Decoder;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import java.util.List;

@Configuration
@EnableWebFlux
@EnableWebFluxSecurity
public class WebSecurityConfiguration implements WebFluxConfigurer {

    @Value("${gateway.cors.allowed-origins}")
    private String url;

    private static final List<String> EXCLUDED_PATHS = List.of(
            "/",
            "/favicon.ico",
            "/static/**",
            "/auth/refresh"
    );

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AbstractJackson2Decoder abstractJackson2Decoder() {
        return new Jackson2JsonDecoder();
    }

    @Bean
    public ReactiveAuthenticationManager reactiveAuthenticationManager(
            ExternalUserDetailsService reactiveUserDetailsService,
            PasswordEncoder passwordEncoder
    ) {
        UserDetailsRepositoryReactiveAuthenticationManager authenticationManager =
                new UserDetailsRepositoryReactiveAuthenticationManager(reactiveUserDetailsService);

        authenticationManager.setPasswordEncoder(passwordEncoder);

        return authenticationManager;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        final CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(List.of(url));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of(
                "Access-Control-Allow-Origin",
                "Authorization",
                "Content-Type"
        ));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

//    @Bean
//    public AuthenticationWebFilter authenticationWebFilter(
//            ReactiveAuthenticationManager reactiveAuthenticationManager,
//            JWTConverter jwtConverter,
//
//    )

//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain() {
//
//    }

}
