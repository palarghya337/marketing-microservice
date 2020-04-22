package in.microservice.customermicroservice.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.microservice.customermicroservice.bean.Customer;

@Repository
@Profile(value = "mysql")
public interface CustomerRepositoryMysql
	extends CustomerRepository<Integer>,
	JpaRepository<Customer, Integer> {

}
