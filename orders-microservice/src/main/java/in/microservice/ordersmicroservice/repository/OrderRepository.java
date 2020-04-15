package in.microservice.ordersmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.microservice.ordersmicroservice.bean.Order;

public interface OrderRepository
	extends JpaRepository<Order, Integer>{

}
