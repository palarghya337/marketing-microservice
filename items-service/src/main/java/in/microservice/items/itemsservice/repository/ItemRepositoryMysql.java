package in.microservice.items.itemsservice.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.microservice.items.itemsservice.bean.Item;

@Repository
@Profile(value = "mysql")
@Primary
public interface ItemRepositoryMysql
	extends ItemRepository<Integer>,
	JpaRepository<Item, Integer>{
}
