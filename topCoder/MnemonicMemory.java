import java.util.Arrays;

public class MnemonicMemory {
	public String getPhrase(String number, String[] dictionary) {

		// Sort the dictionary to ensure that we are outputting in
		// alphabetical order
		Arrays.sort(dictionary);

		// Array to keep track of words that we already used
		boolean[] alreadyUsed = new boolean[dictionary.length];

		String ans = "";
		for (int i=0; i<number.length(); i++) {
			int num = number.charAt(i) - '0'; // Cool trick to convert char to int

			// Finds the first matched string to append to the answer
			for (int j=0; j<dictionary.length; j++) {
				if (dictionary[j].length() == num && !alreadyUsed[j]) {
					alreadyUsed[j] = true;
					ans += dictionary[j] + " ";
					break;
				}
			}
		}

		// Trim out extra spaces
		return ans.trim();
	}
}
