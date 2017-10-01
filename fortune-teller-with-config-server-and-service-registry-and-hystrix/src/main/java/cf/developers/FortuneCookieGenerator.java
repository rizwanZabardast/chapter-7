package cf.developers;

import java.net.URI;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RefreshScope
@Component
public class FortuneCookieGenerator {

	@Autowired
	RestTemplate restTemplate;

	@Value("${words}")
	private String[] words;

	@Value("${length}")
	private int fortuneLength;

	@HystrixCommand(fallbackMethod = "defaultGenerate")
	public void generate() {

		URI uri = UriComponentsBuilder.fromUriString("//fortune-teller-api/generator")
				.queryParam("length", fortuneLength).build().toUri();

		String sentence = restTemplate.getForObject(uri, String.class);

		System.out.println(sentence);

	}
	
	public void defaultGenerate() {
		Random random = new Random();

		int wordsInSentence = 0;
		StringBuilder randomSentenceStringBuilder = new StringBuilder();

		while (fortuneLength != wordsInSentence) {
			int pos = random.nextInt(words.length);
			String word = words[pos];
			randomSentenceStringBuilder.append(word).append(" ");
			wordsInSentence++;
		}

		System.out.println(randomSentenceStringBuilder.toString());
	}

}
