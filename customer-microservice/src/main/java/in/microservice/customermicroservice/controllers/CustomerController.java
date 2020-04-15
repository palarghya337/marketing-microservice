package in.microservice.customermicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.microservice.customermicroservice.bean.Customer;
import in.microservice.customermicroservice.services.CustomerService;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping(value = "all")
	public List<Customer> getCustomers() {
		return service.getCustomers();
	}
	
	@GetMapping(value = "{id}")
	public Customer getCustomer(@PathVariable int id) {
		return service.getCustomer(id);
	}
	
	@PostMapping(value = "addNew")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}
	
	@PutMapping(value = "updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	
	@DeleteMapping(value = "delete")
	public boolean deleteAllCustomers() {
		return service.deleteAllCustomer();
	}
	
	@DeleteMapping(value = "delete/{id}")
	public boolean deleteCustomerById(@PathVariable int id) {
		return service.deleteCustomer(id);
	}
}
