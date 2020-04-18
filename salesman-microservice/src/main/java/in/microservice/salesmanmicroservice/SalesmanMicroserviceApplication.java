package in.microservice.salesmanmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SalesmanMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesmanMicroserviceApplication.class, args);
	}

}
