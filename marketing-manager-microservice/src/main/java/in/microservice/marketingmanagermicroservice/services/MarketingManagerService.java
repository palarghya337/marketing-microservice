package in.microservice.marketingmanagermicroservice.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.microservice.marketingmanagermicroservice.bean.Customer;
import in.microservice.marketingmanagermicroservice.bean.Order;
import in.microservice.marketingmanagermicroservice.exceptions.NoDataFoundException;

@Service
public class MarketingManagerService {

	@Autowired
	@Qualifier(value = "salesmanWebClient")
	private WebClient salesmanWebClient;
	
	@Autowired
	@Qualifier(value = "ordersWebClient")
	private WebClient orderWebClient;
	
	@Autowired
	@Qualifier(value = "customerWebClient")
	private WebClient customerWebClient;
	
	private List<Customer> customerList;
	private List<Order> orderList;
	private Map<Integer, List<Order>> customerIdOrderList;
	
	public List<Customer> getAllCustomers() {
		
		if (customerList == null) {
			
			customerList = customerWebClient.get()
					.uri("all")
					.retrieve()
					.bodyToFlux(Customer.class)
					.collectList()
					.block();
		}
		return customerList;
	}
	
	public Customer getCustomerForOrderId(int id) {
		
		Order order = getOrder(id);
		if (order == null) {
			throw new NoDataFoundException("Could not find order with id-" + id);
		}
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
	public List<Order> getOrdersOfCustomerId(int customerId) {
		Customer customer = customerWebClient.get()
				.uri("{id}", customerId)
				.retrieve()
				.bodyToMono(Customer.class)
				.block();
		
		if (customer == null) {
			throw new NoDataFoundException("Could not find customer with id-" + customerId);
		}
		return getMapOfCustomerIdOrder().get(customer.getId());
	}
	public Map<Integer, List<Order>> getMapOfCustomerIdOrder() {
		
		if (customerIdOrderList == null) {
			
			List<Order> orders = getAllOrders();
			customerIdOrderList = orders.parallelStream()
					.collect(Collectors.groupingBy(Order::getCustomerId));
		}
		return customerIdOrderList;
	}
	public List<Order> getAllOrders() {
		
		if (orderList == null) {
			
			orderList = orderWebClient.get()
					.uri("all")
					.retrieve()
					.bodyToFlux(Order.class)
					.collectList()
					.block();
		}
		return orderList;
	}
}
