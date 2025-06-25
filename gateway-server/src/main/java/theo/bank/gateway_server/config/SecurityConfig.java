//package theo.bank.gateway_server.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration
//@EnableWebFluxSecurity // Enables reactive security (WebFlux style)
//public class SecurityConfig {
//
//    // Define the main security filter chain for Spring Security
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        return http
//                .csrf(csrf -> csrf.disable())// Disable CSRF (not needed for APIs)
//                .authorizeExchange(auth -> auth
//                        // IMPORTANT CHANGE: Permit /bank/login, as this is the path *after* gateway rewriting
////                        .pathMatchers("/bank/login").permitAll()// Public route (e.g., login)
//                        .anyExchange().authenticated()// Everything else requires a valid token
//                )
//                .build();// No session, no state — JWT handles auth
//    }
//}
//
