import java.util.*;

public class Main {
	static char[] ciph = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
			'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
			'Z' };
	static char[] plain = { 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U' };
	static final String newLine = "\n", START = "START",END = "END",term ="ENDOFINPUT";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<Character, Character> dict = new HashMap<Character, Character>();
		for(int i=0;i<ciph.length;i++){
			dict.put(ciph[i],plain[i]);
		} String curr,ret = "";
		for (;;) {
			curr = in.nextLine();
			if(curr.equals(START)) continue;
			if(curr.equals(END)){ ret+=newLine; continue;}
			if(curr.equals(term)) break;
			for(int i=0;i<curr.length();i++){
				ret+= dict.containsKey(curr.charAt(i)) ? dict.get(curr.charAt(i)): curr.charAt(i);
			}
		}System.out.println(ret);
	}
}
