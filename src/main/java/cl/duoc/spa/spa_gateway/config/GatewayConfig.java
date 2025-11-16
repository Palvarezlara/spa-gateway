package cl.duoc.spa.spa_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Catálogo (servicios + blogs)
                .route("catalog-route", r -> r
                        .path("/api/v1/catalog/**")
                        .uri("http://localhost:8082"))
                // Usuarios
                .route("users-route", r -> r
                        .path("/api/v1/users/**")
                        .uri("http://localhost:8081"))
                // Ventas
                .route("sales-route", r -> r
                        .path("/api/v1/sales/**")
                        .uri("http://localhost:8083"))
                .build();
    }
}
