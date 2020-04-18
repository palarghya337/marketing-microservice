package in.microservice.marketingmanagermicroservice.services;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MarketingManagerContext {
	
	@Bean(name = "salesmanWebClient")
	public WebClient getSalesmanWebClient() {
		String baseUrl = "http://salesman-microservice/salesman";
		return getWebClient().baseUrl(baseUrl).build();
	}
	@Bean(name = "customerWebClient")
	public WebClient getCustomerWebClient() {
		String baseUrl = "http://customer-microservice/customers/";
		return getWebClient()/*.baseUrl(baseUrl)*/.build();
	}
	@Bean(name = "ordersWebClient")
	public WebClient getOrdersWebClient() {
		String baseUrl = "http://orders-microservice/orders/";
		return getWebClient().baseUrl(baseUrl).build();
	}
	@LoadBalanced
	public WebClient.Builder getWebClient() {
		return WebClient.builder();
	}
}
