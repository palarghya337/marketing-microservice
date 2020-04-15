package in.microservice.customermicroservice.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.microservice.customermicroservice.bean.Customer;
import in.microservice.customermicroservice.repositories.CustomerRepository;

@Service
public class CustomerService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerRepository repository;
	
	public List<Customer> getCustomers() {
		return repository.findAll();
	}
	public Customer getCustomer(int id) {
		return repository.findById(id).orElse(null);
	}
	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}
	public Customer updateCustomer(Customer customer) {
		return repository.saveAndFlush(customer);
	}
	public boolean deleteAllCustomer() {
		try {
			repository.deleteAll();
		} catch (Exception e) {
			LOGGER.error("Exception while deleting all the customer data");
			return false;
		}
		return true;
	}
	public boolean deleteCustomer(int id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			LOGGER.error("Exception while removing customer data from database for customer ID: {0}", id, e);
			return false;
		}
		return true;
	}
}
