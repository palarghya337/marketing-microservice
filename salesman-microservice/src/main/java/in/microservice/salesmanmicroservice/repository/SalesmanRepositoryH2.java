package in.microservice.salesmanmicroservice.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import in.microservice.salesmanmicroservice.bean.Salesman;

@Repository
public class SalesmanRepositoryH2
	implements SalesmanRepository<Integer> {

	private Map<Integer, Salesman> salesmanMap;
	
	public SalesmanRepositoryH2() {
		init();
	}
	private void init() {
		Salesman salesman = new Salesman();
		salesman.setCity("salesmanCity");
		salesman.setCommission(55.20);
		salesman.setId(1001);
		salesman.setName("salesmanName1");
		salesmanMap = new HashMap<>();
		save(salesman);
	}
	@Override
	public List<Salesman> findAll() {
		return new ArrayList<>(salesmanMap.values());
	}

	@Override
	public Optional<Salesman> findById(Integer id) {
		return Optional.of(salesmanMap.get(id));
	}

	@Override
	public void deleteAll() {
		salesmanMap.clear();
	}

	@Override
	public void deleteById(Integer id) {
		salesmanMap.remove(id);
	}

	@Override
	public Salesman save(Salesman element) {
		return salesmanMap.put(element.getId(), element);
	}

	@Override
	public Salesman saveAndFlush(Salesman element) {
		return save(element);
	}
}
