package theo.bank.gateway_server.config;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openEndpoints = List.of(
            "/authentication/bank/login",
            "/user/bank/register"
    );

    public Predicate<ServerHttpRequest> isSecured = serverHttpRequest -> openEndpoints
            .stream()
            .noneMatch(uri -> serverHttpRequest.getURI().getPath().contains(uri));
}
