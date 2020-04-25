package in.microservice.items.itemsservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.microservice.items.itemsservice.bean.Item;
import in.microservice.items.itemsservice.exceptions.ItemNotFoundException;
import in.microservice.items.itemsservice.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository<Integer> repository;
	
	public List<Item> getAllItems() {
		return repository.findAll();
	}
	public Item getItem(int id) {
		
		Optional<Item> item = repository.findById(id);
		return item.orElseThrow(() ->
			new ItemNotFoundException("Item not found for id " + id)
			);
	}
	public Item addNewItem(Item item) {
		return repository.save(item);
	}
	public Item updateItem(Item item) {
		return repository.saveAndFlush(item);
	}
	public boolean deleteItem(int id) {
		repository.deleteById(id);
		return true;
	}
	public boolean deleteAllItems() {
		repository.deleteAll();
		return true;
	}
}
