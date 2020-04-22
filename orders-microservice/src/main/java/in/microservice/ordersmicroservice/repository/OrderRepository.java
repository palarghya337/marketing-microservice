package in.microservice.ordersmicroservice.repository;

import java.util.List;
import java.util.Optional;

import in.microservice.ordersmicroservice.bean.Order;

public interface OrderRepository<IDType> {
	List<Order> findAll();
	Optional<Order> findById(IDType id);
	void deleteAll();
	void deleteById(IDType id);
	Order save(Order element);
	Order saveAndFlush(Order element);
}
