package com.pauloelienay.gatewayservice.config;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
//	@Bean
//	public DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator
//			(ReactiveDiscoveryClient client, DiscoveryLocatorProperties properties) {
//		return new DiscoveryClientRouteDefinitionLocator(client, properties);
//	}

	@Bean
	public RouteLocator getRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("ratings", p -> p.path("/ratings/**").uri("lb://RATING-SERVICE"))
			.route("movies-info", p -> p.path("/movies/**").uri("lb://MOVIE-INFO-SERVICE"))
			.route("movie-catalog", p -> p.path("/catalog/**").uri("lb://MOVIE-CATALOG-SERVICE"))
			.build();
	}
}
