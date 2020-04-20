package in.microservice.marketingmanagermicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.microservice.marketingmanagermicroservice.bean.Customer;
import in.microservice.marketingmanagermicroservice.bean.Order;
import in.microservice.marketingmanagermicroservice.services.MarketingManagerService;

@RestController
@RequestMapping(value = "manager")
public class ManagerController {

	@Autowired
	private MarketingManagerService service;
	
	@GetMapping(value = "getAllCustomers")
	public List<Customer> getListOfCustomer() {
		return service.getAllCustomers();
	}
	
	@GetMapping(value = "customer/order/{id}")
	public Customer getCustomerByOrderId(@PathVariable int id) {
		return service.getCustomerForOrderId(id);
	}
	@GetMapping(value = "orders/customer/{id}")
	public List<Order> getOrdersOfCustomerId(@PathVariable int id) {
		return service.getOrdersOfCustomerId(id);
	}
}
