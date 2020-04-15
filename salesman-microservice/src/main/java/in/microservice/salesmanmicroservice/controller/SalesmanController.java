package in.microservice.salesmanmicroservice.controller;

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

import in.microservice.salesmanmicroservice.bean.Salesman;
import in.microservice.salesmanmicroservice.service.SalesmanService;

@RestController
@RequestMapping(value = "salesman")
public class SalesmanController {

	@Autowired
	private SalesmanService service;
	
	@GetMapping(value = "all")
	public List<Salesman> getSalesmanList() {
		return service.getSalesmanList();
	}
	
	@GetMapping(value = "{id}")
	public Salesman getSalesmanById(@PathVariable int id) {
		return service.getSalesmanById(id);
	}
	
	@PostMapping(value = "newSalesman")
	public Salesman addNewSalesman(@RequestBody Salesman salesman) {
		return service.addNewSalesman(salesman);
	}
	
	@PutMapping(value = "update")
	public Salesman updateSalesman(@RequestBody Salesman salesman) {
		return service.updateSalesman(salesman);
	}
	
	@DeleteMapping(value = "deleteAll")
	public boolean deleteAllSalesman() {
		return service.deleteAll();
	}
	
	@DeleteMapping(value = "delete/{id}")
	public boolean deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
}
