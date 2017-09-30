package cf.developers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class FortuneTellerApplication {
	
	@Autowired
	FortuneCookieGenerator fortuneCookieGenerator;

	public static void main(String[] args) {
		SpringApplication.run(FortuneTellerApplication.class, args);
	}

	@Scheduled(cron = "${cron.schedule}")
	private void generateFortune() {
		fortuneCookieGenerator.generate();
	}
}
