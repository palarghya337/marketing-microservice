package in.microservice.ordersmicroservice.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import in.microservice.ordersmicroservice.bean.Order;

@Repository
public class OrderRepositoryH2 implements OrderRepository<Integer> {

	private Map<Integer, Order> orderMap;
	
	public OrderRepositoryH2() {
		init();
	}

	private void init() {
		
		Order order = new Order();
		order.setCustomerId(1001);
		order.setDateTime(LocalDateTime.now());
		order.setOrderNumber(101);
		order.setPurchaseAmt(5632.42);
		order.setSalesmanId(1001);
		orderMap = new HashMap<>();
		save(order);
	}

	@Override
	public List<Order> findAll() {
		return new ArrayList<>(orderMap.values());
	}

	@Override
	public Optional<Order> findById(Integer id) {
		return Optional.of(orderMap.get(id));
	}

	@Override
	public void deleteAll() {
		orderMap.clear();
	}

	@Override
	public void deleteById(Integer id) {
		orderMap.remove(id);
	}

	@Override
	public Order save(Order element) {
		return orderMap.put(element.getOrderNumber(), element);
	}

	@Override
	public Order saveAndFlush(Order element) {
		return save(element);
	}
}
