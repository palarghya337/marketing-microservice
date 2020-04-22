package in.microservice.ordersmicroservice.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.microservice.ordersmicroservice.bean.Order;

@Repository
@Profile(value = "mysql")
public interface OrderRepositoryMysql
	extends OrderRepository<Integer>, JpaRepository<Order, Integer> {

}
