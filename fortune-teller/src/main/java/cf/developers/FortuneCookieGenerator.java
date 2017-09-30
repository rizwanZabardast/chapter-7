package cf.developers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FortuneCookieGenerator {
	
	@Value("${words}")
	private String[] words;
	
	@Value("${length}")
	private int fortuneLength;

	public void generate() {
		
		Random random = new Random();
		
		int wordsInSentence = 0;
		StringBuilder randomSentenceStringBuilder = new StringBuilder();
		
		while(fortuneLength != wordsInSentence) {
			int pos = random.nextInt(words.length);
			String word = words[pos];
			randomSentenceStringBuilder.append(word).append(" ");
			wordsInSentence++;
		}
		
		System.out.println(randomSentenceStringBuilder.toString());
		
	}

}
