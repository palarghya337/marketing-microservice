package in.microservice.salesmanmicroservice.repository;

import java.util.List;
import java.util.Optional;

import in.microservice.salesmanmicroservice.bean.Salesman;

public interface SalesmanRepository<IDType> {
	List<Salesman> findAll();
	Optional<Salesman> findById(IDType id);
	void deleteAll();
	void deleteById(IDType id);
	Salesman save(Salesman element);
	Salesman saveAndFlush(Salesman element);
}
