package in.microservice.ordersmicroservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.microservice.ordersmicroservice.bean.Order;
import in.microservice.ordersmicroservice.repository.OrderRepository;

@Service
public class OrderService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(OrderService.class);
	
	@Autowired
	private OrderRepository<Integer> repository;
	
	public List<Order> getOrders() {
		return repository.findAll();
	}
	public Order getOrder(int id) {
		return repository.findById(id).orElse(null);
	}
	public Order saveNew(Order order) {
		return repository.save(order);
	}
	public Order updateOrder(Order order) {
		return repository.saveAndFlush(order);
	}
	public boolean deleteAllOrders() {
		try {
			repository.deleteAll();
		} catch (Exception e) {
			LOGGER.error("Exception while deleting all the orders", e);
			return false;
		}
		return true;
	}
	public boolean deleteOrderById(int id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			LOGGER.error("Exception while deleting Order: {0}", id, e);
			return false;
		}
		return true;
	}
}
