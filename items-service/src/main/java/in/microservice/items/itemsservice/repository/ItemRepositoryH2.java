package in.microservice.items.itemsservice.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import in.microservice.items.itemsservice.bean.Item;

@Repository
public class ItemRepositoryH2
	implements ItemRepository<Integer> {

	private Map<Integer, Item> mapOfItems;
	
	public ItemRepositoryH2() {
		mapOfItems = new HashMap<>();
		defaultValueForH2DB();
	}
	private void defaultValueForH2DB() {
		
		Item item = new Item();
		item.setDetails("New iPhone SE with new features.");
		item.setExpireDate(null);
		item.setId(1001);
		item.setManufacturingDate(LocalDateTime.of(2020, 04, 15, 0, 0));
		item.setName("iPhone SE");
		item.setPrice(41999.00);
		item.setSerialNo(123654);
		save(item);
	}
	@Override
	public List<Item> findAll() {
		return new ArrayList<>(mapOfItems.values());
	}

	@Override
	public Optional<Item> findById(Integer id) {
		return Optional.of(mapOfItems.get(id));
	}

	@Override
	public void deleteAll() {
		mapOfItems.clear();
	}

	@Override
	public void deleteById(Integer id) {
		mapOfItems.remove(id);
	}

	@Override
	public Item save(Item element) {
		return mapOfItems.put(element.getId(), element);
	}

	@Override
	public Item saveAndFlush(Item element) {
		return save(element);
	}
}
