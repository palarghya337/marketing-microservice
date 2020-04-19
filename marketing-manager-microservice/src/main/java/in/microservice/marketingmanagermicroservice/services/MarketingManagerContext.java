package in.microservice.marketingmanagermicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MarketingManagerContext {
	
	@Bean(name = "salesmanWebClient")
	public WebClient getSalesmanWebClient(
			@Autowired WebClient.Builder webClientBuilder) {
		String baseUrl = "http://salesman-microservice/salesman";
		return webClientBuilder.baseUrl(baseUrl).build();
	}
	@Bean(name = "customerWebClient")
	public WebClient getCustomerWebClient(
			@Autowired WebClient.Builder webClientBuilder) {
		
		String baseUrl = "http://customer-microservice/customers/";
		return webClientBuilder.baseUrl(baseUrl).build();
	}
	@Bean(name = "ordersWebClient")
	public WebClient getOrdersWebClient(
			@Autowired WebClient.Builder webClientBuilder) {
		String baseUrl = "http://orders-microservice/orders/";
		return webClientBuilder.baseUrl(baseUrl).build();
	}
	@Bean
	@LoadBalanced
	public WebClient.Builder getWebClient() {
		return WebClient.builder();
	}
}
