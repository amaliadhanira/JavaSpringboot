package com.in28minutes.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f->f
								.addRequestHeader("MyHeader", "MyURI")
								.addRequestHeader("Param", "MyValue"))
						.uri("http://httpbin.org:80"))
				.route(p-> p.path("/currency-exchange/**")
						.uri("lb://CURRENCY-EXCHANGE-SERVICE"))
				.build();
	}

}
