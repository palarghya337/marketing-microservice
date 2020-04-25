package in.microservice.items.itemsservice.repository;

import java.util.List;
import java.util.Optional;

import in.microservice.items.itemsservice.bean.Item;


public interface ItemRepository<IDType> {
	
	List<Item> findAll();
	Optional<Item> findById(IDType id);
	void deleteAll();
	void deleteById(IDType id);
	Item save(Item element);
	Item saveAndFlush(Item element);
}
