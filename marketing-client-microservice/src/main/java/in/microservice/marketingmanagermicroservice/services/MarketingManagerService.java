package in.microservice.marketingmanagermicroservice.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.microservice.marketingmanagermicroservice.bean.Customer;
import in.microservice.marketingmanagermicroservice.bean.Order;

@Service
public class MarketingManagerService {

//	@Autowired
	private WebClient salesmanWebClient = WebClient.builder()
			.baseUrl("localhost:8081/salesman").build();
	private WebClient orderWebClient = WebClient.builder()
			.baseUrl("http://localhost:8082/orders/").build();
	private WebClient customerWebClient = WebClient.builder()
			.baseUrl("http://localhost:8083/customers/").build();
	
	public List<Customer> getAllCustomers() {
		
		return customerWebClient.get()
				.uri("all")
				.retrieve()
				.bodyToFlux(Customer.class)
				.collectList()
				.block();
	}
	
	public Customer getCustomerForOrderId(int id) {
		
		Order order = getOrder(id);
		int customerId = order.getCustomerId();
		return customerWebClient.get()
				.uri("{id}", customerId)
				.retrieve()
				.bodyToMono(Customer.class)
				.block();
	}
	public Order getOrder(int id) {
		return orderWebClient.get()
				.uri("{id}", id)
				.retrieve()
				.bodyToMono(Order.class)
				.block();
	}
}
