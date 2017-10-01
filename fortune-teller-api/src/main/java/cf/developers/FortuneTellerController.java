package cf.developers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.maximeroussy.invitrode.RandomWord;
import main.java.com.maximeroussy.invitrode.WordLengthException;

@RestController
@RequestMapping("/generator")
public class FortuneTellerController {

	@RequestMapping(method = RequestMethod.GET, params = "length")
	public String createRandomSentence(@RequestParam("length") int length) throws Exception {
		String sentence = null;

		StringBuilder sb = new StringBuilder();

		try {
			while (length != 0) {
				sb.append(RandomWord.getNewWord(5)).append(" ");
				length--;
			}
			sentence = sb.toString();
		} catch (WordLengthException e) {
			throw new Exception(e.getMessage());
		}
		return sentence;
	}

}
