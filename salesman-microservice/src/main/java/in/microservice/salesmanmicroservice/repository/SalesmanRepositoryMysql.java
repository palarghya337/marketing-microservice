package in.microservice.salesmanmicroservice.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.microservice.salesmanmicroservice.bean.Salesman;

@Repository
@Profile(value = "mysql")
@Primary
public interface SalesmanRepositoryMysql
	extends SalesmanRepository<Integer>,
	JpaRepository<Salesman, Integer>{

}
