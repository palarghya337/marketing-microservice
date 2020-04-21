package in.microservice.marketingmanagermicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;

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
		
		/*
		 * Setting the timeout globally (http client level)
		 * so that if request takes more time to process than
		 * the given time, it should throw time out exception.
		 **/
		HttpClient httpClient = HttpClient.create()
				.tcpConfiguration(client
						-> client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000)
						.doOnConnected(conn
								-> conn.addHandlerLast(new ReadTimeoutHandler(10))
								.addHandlerLast(new WriteTimeoutHandler(10))));
		
		ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient.wiretap(true));
		return WebClient.builder().clientConnector(connector);
	}
}
