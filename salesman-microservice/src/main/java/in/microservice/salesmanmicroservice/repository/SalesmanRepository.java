package in.microservice.salesmanmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.microservice.salesmanmicroservice.bean.Salesman;

@Repository
public interface SalesmanRepository
	extends JpaRepository<Salesman, Integer>{

}
