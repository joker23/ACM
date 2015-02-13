 public class DecipherabilityEasy {

	public String check(String s, String t) {
		boolean done = false;

		if (s.length() != t.length() + 1) {
			return "Impossible";
		}

		int ptr = 0;
		for (int i=0; i<s.length(); i++) {
			String test = s.substring(0,i) + s.substring(i + 1, s.length());

			if (test.equals(t)) {
				return "Possible";
			}
		}

		return "Impossible";
	}
}
