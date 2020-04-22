package in.microservice.salesmanmicroservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.microservice.salesmanmicroservice.bean.Salesman;
import in.microservice.salesmanmicroservice.repository.SalesmanRepository;

@Service
public class SalesmanService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SalesmanService.class);
	@Autowired
	private SalesmanRepository<Integer> repository;

	public List<Salesman> getSalesmanList() {
		return repository.findAll();
	}
	public Salesman getSalesmanById(int id) {
		return repository.findById(id).orElse(null);
	}
	public Salesman addNewSalesman(Salesman salesman) {
		return repository.save(salesman);
	}
	public Salesman updateSalesman(Salesman salesman) {
		return repository.saveAndFlush(salesman);
	}
	public boolean deleteAll() {
		
		try {
			repository.deleteAll();
		} catch (Exception e) {
			LOGGER.error("Exception while deleting all the salesman object", e);
			return false;
		}
		return true;
	}
	public boolean deleteById(int id) {
		
		try {
			repository.deleteById(id);
		} catch(Exception e) {
			LOGGER.error("Exception while deleting the salesman id: {0}", id, e);
			return false;
		}
		return true;
	}
}
