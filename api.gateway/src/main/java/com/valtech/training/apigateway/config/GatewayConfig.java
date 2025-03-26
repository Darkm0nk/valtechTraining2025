package com.valtech.training.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes().route(p->p.path("/get").uri("http://httpbin.org:80"))
				.route(p->p.path("/api/v1/employees/*").uri("lb://EMPLOYEESERVICE"))
				.route(p->p.path("/api/v1/leaves/*").uri("lb://LEAVESERVICE"))
				.route(p->p.path("/api/v1/leaveMasters/*").uri("lb://LEAVESERVICE"))
				.route(p->p.path("/api/v1/questions/*").uri("lb://QUIZSERVICE"))
				.route(p->p.path("/api/v1/quiz/*").uri("lb://QUIZSERVICE"))
				.route(p->p.path("/api/v1/users/*").uri("lb://REGISTERSERVICE"))
				.build();

	}
}
