package cf.developers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FortuneTellerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortuneTellerWebApplication.class, args);
	}
}


