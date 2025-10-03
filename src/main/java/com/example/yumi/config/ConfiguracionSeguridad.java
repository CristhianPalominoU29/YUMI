package com.example.yumi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad {
    @Autowired
    private Filtrojwt filtroJwt;

    @Bean
    public BCryptPasswordEncoder codificadorContrasena() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain cadenaFiltrosSeguridad(HttpSecurity http) throws Exception {
        http
                // 1. Deshabilitar CSRF (Crucial para APIs sin sesiones)
                .csrf(csrf -> csrf.disable())

                // 2. Definición de Políticas de Autorización por Endpoint
                .authorizeHttpRequests(auth -> auth
                        // Rutas 1: Endpoints Públicos (Registro e inicio de sesión)
                        .requestMatchers("/api/**").permitAll()
                       // .requestMatchers("/").permitAll() // Por si necesitas la raíz pública

                        // Rutas 2: Endpoints para Administrador (Requieren el rol ADMIN)
                        // **Asegúrate de que tu rol se llama 'ADMIN'**
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/productos/admin/**").hasRole("ADMIN")

                        // Rutas 3: Endpoints para Usuarios Registrados (Requieren autenticación)
                        // Por ejemplo, ver o crear productos si tu lógica lo permite.
                        // **¡Esta línea DEBE ir al final de las reglas protegidas!**
                        .requestMatchers("/api/profile/","/api/cart/**").authenticated()
                        .anyRequest().authenticated()
                )

                // 3. Configuración de Sesión (StateLess para JWT)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // 4. Integración de Filtro JWT
                .addFilterBefore(filtroJwt, UsernamePasswordAuthenticationFilter.class);

        // Opcional: Manejo de Excepciones para devolver 401/403
        http.exceptionHandling(exceptions -> exceptions
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.sendError(jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                        })
                // Aquí puedes añadir un handler para Forbidden (403) si el usuario no tiene rol
                // .accessDeniedHandler((request, response, accessDeniedException) -> {
                //     response.sendError(jakarta.servlet.http.HttpServletResponse.SC_FORBIDDEN, "Forbidden");
                // })
        );

        return http.build();
    }
}