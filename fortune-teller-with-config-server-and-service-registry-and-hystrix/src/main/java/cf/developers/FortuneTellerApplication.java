package cf.developers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@EnableCircuitBreaker
@EnableDiscoveryClient
public class FortuneTellerApplication {

	@Autowired
	FortuneCookieGenerator fortuneCookieGenerator;

	public static void main(String[] args) {
		SpringApplication.run(FortuneTellerApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Scheduled(cron = "${cron.schedule}")
	private void generateFortune() {
		fortuneCookieGenerator.generate();
	}
}
