import java.util.*;

public class Main {
	final static String[] LET = { "ABC", "DEF", "GHI", "JKL", "MNO", "PRS",
			"TUV", "WXY" };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<Character, Character> interp = new HashMap<Character, Character>();
		HashMap<String, Integer> cache = new HashMap<String, Integer>();
		PriorityQueue<String> pq = new PriorityQueue<String>();
		for (int i = 1; i < LET.length + 1; i++) {
			for (int j = 0; j < LET[i - 1].length(); j++) {
				interp.put(LET[i - 1].charAt(j), (char) (i + 49));
			}
		}
		int num = in.nextInt();
		while (num-- > 0) {
			String test = in.next();
			for (char key : interp.keySet()) {
				test = test.replace(key, interp.get(key));
			}
			String ret = "";
			int j = 0;
			for (int i = 0; i < test.length(); i++) {
				if (j == 3) {
					ret += '-';
					j++;
				}
				if (test.charAt(i) >= '0' && test.charAt(i) <= '9') {
					ret += test.charAt(i);
					j++;
				}
			}
			if (cache.containsKey(ret)) {
				int value = cache.get(ret);
				cache.put(ret, value + 1);
			} else {
				cache.put(ret, 1);
				pq.add(ret);
			}
		}
		boolean repeats = false;
		while(!pq.isEmpty()){
			String th = pq.poll();
			if(cache.get(th)>1){
				System.out.println(th+" "+cache.get(th));
				repeats =true;
			}
		}
		if(!repeats)
			System.out.println("No duplicates.");
	}
}
