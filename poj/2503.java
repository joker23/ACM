import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashMap<String,String> dict = new HashMap<String, String>();
		while(true){
			st = new StringTokenizer(in.readLine());
			if(st.countTokens()<2) break;
			String word = st.nextToken();
			dict.put(st.nextToken(), word);
		}
		while(true){
			String ret = in.readLine();
			if(ret.length() == 0) break;
			if(dict.containsKey(ret)) System.out.println(dict.get(ret));
			else System.out.println("eh");
			
		}
	}

}
