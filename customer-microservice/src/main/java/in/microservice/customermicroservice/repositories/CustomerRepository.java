package in.microservice.customermicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.microservice.customermicroservice.bean.Customer;

@Repository
public interface CustomerRepository
	extends JpaRepository<Customer, Integer> {

}
