package in.microservice.customermicroservice.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import in.microservice.customermicroservice.bean.Customer;

@Repository
public class CustomerRepositoryH2
	implements CustomerRepository<Integer> {

	private Map<Integer, Customer> customers;
	
	public CustomerRepositoryH2() {
		init();
	}
	private void init() {
		
		Customer customer = new Customer();
		customer.setId(1001);
		customer.setName("customerOne");
		customer.setCity("city1");
		customer.setGrade(6);
		customers = new HashMap<>();
		save(customer);
	}
	@Override
	public List<Customer> findAll() {
		
		return new ArrayList<Customer>(customers.values());
	}

	@Override
	public Optional<Customer> findById(Integer id) {
		return Optional.of(customers.get(id));
	}

	@Override
	public void deleteAll() {
		customers.clear();
	}

	@Override
	public void deleteById(Integer id) {
		customers.remove(id);
	}

	@Override
	public Customer save(Customer element) {
		return customers.put(element.getId(), element);
	}

	@Override
	public Customer saveAndFlush(Customer element) {
		return save(element);
	}
}
