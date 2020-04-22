package in.microservice.customermicroservice.repositories;

import java.util.List;
import java.util.Optional;

import in.microservice.customermicroservice.bean.Customer;

public interface CustomerRepository<IDType> {
	List<Customer> findAll();
	Optional<Customer> findById(IDType id);
	void deleteAll();
	void deleteById(IDType id);
	Customer save(Customer element);
	Customer saveAndFlush(Customer element);
}
