package in.microservice.items.itemsservice.controllers;

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

import in.microservice.items.itemsservice.bean.Item;
import in.microservice.items.itemsservice.service.ItemService;

@RestController
@RequestMapping(value = "items")
public class ItemController {

	@Autowired
	private ItemService service;
	
	@PostMapping(value = "add")
	public Item addNewItem(@RequestBody Item item) {
		return service.addNewItem(item);
	}
	@PutMapping(value = "update")
	public Item updateItem(@RequestBody Item item) {
		return service.updateItem(item);
	}
	@GetMapping(value = "get/all")
	public List<Item> getItems() {
		return service.getAllItems();
	}
	@GetMapping(value = "get/{id}")
	public Item getItem(@PathVariable int id) {
		return service.getItem(id);
	}
	@DeleteMapping(value = "delete/{id}")
	public boolean deleteItem(@PathVariable int id) {
		return service.deleteItem(id);
	}
	@DeleteMapping(value = "delete/all")
	public boolean deleteAllItems() {
		return service.deleteAllItems();
	}
}
