package theo.bank.gateway_server.config;

//import com.netflix.spectator.impl.Config;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@Component
public class JwtAuthFilter  extends AbstractGatewayFilterFactory<JwtAuthFilter.Config> { // Removed 'Ordered' interface


    private final RouteValidator routeValidator;
    private final JwtUtil jwtUtil;

    public JwtAuthFilter(RouteValidator routeValidator, JwtUtil jwtUtil) {
        super(Config.class);
        this.routeValidator = routeValidator;
        this.jwtUtil = jwtUtil;
    }

    private static final Logger log = LoggerFactory.getLogger(JwtAuthFilter.class);

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if(routeValidator.isSecured.test(exchange.getRequest())){
                log.info(exchange.getRequest().getHeaders().toString());
                if(!exchange.getRequest().getHeaders().containsKey("Authorization")){
                    throw new RuntimeException("Authorization header not found");
                }
                String authToken = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
                if(authToken != null && authToken.startsWith("Bearer ")){
                    authToken = authToken.substring(7);
                }
                Objects.requireNonNull(authToken, "Authentication token is missing");

                if(jwtUtil.isTokenValid(authToken)){
                    String username = jwtUtil.extractUsername(authToken);
                    exchange = exchange.mutate()
                            .request(exchange.getRequest().mutate()
                                    .header("X-Authenticated-User", username)
                                    .build())
                            .build();
                    return chain.filter(exchange);
                }
                if(jwtUtil.isTokenValid(authToken)){
                    String username = jwtUtil.extractUsername(authToken);
                    exchange = exchange.mutate()
                            .request(exchange.getRequest().mutate()
                                    .header("X-Authenticated-User", username)
                                    .build())
                            .build();
                    return chain.filter(exchange);
                }

                throw new RuntimeException("invalid authentication token");
            }
            return chain.filter(exchange);
        });
    }

    @Component
    public static class Config{}
}
