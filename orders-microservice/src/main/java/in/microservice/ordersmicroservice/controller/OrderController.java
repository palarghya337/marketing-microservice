package in.microservice.ordersmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.microservice.ordersmicroservice.bean.Order;
import in.microservice.ordersmicroservice.service.OrderService;

@RestController
@RequestMapping(value = "orders")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping(value = "all")
	public List<Order> getOrders() {
		return service.getOrders();
	}
	
	@GetMapping(value = "{id}")
	public Order getOrder(@PathVariable int id) {
		return service.getOrder(id);
	}
	
	@PostMapping(value = "newOrder")
	public Order createNewOrder(@RequestBody Order order) {
		return service.saveNew(order);
	}
	
	@PutMapping(value = "updateOrder")
	public Order updateOrder(@RequestBody Order order) {
		return service.updateOrder(order);
	}
	
	@DeleteMapping(value = "delete")
	public boolean deleteOrders() {
		return service.deleteAllOrders();
	}
	
	@DeleteMapping(value = "delete/{id}")
	public boolean deleteById(@PathVariable int id) {
		return service.deleteOrderById(id);
	}
}
