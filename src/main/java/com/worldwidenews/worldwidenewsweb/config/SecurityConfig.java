package com.worldwidenews.worldwidenewsweb.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // Permitir acceso a recursos estáticos
                                .requestMatchers(request -> "/admin".equals(request.getServletPath())).authenticated() // Requiere autenticación para /admin
                                .anyRequest().permitAll() // Permite acceso sin autenticación a todas las demás rutas
                )
                .httpBasic(withDefaults());

        return http.build();
    }
}