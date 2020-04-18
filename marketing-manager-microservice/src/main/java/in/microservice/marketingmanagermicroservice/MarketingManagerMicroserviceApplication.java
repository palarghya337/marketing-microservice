package in.microservice.marketingmanagermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MarketingManagerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketingManagerMicroserviceApplication.class, args);
	}

}
