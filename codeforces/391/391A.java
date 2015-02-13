import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	//IO tools
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;

	//static variables

	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		//code starts here
		char[] str = in.readLine().trim().toCharArray();
		int[] count = new int[str.length];

		count[0] = 1;

		int ans = 0;

		for(int i=1; i< str.length; i++){
			if(str[i] == str[i-1]){
				count[i] = count[i-1] + 1;
			} else {
				count[i] = 1;
				ans += (count[i-1] % 2 == 0) ? 1 : 0;
			}
		}

		if(count[count.length -1 ] != 1 && count[count.length - 1]%2 == 0){
			ans ++;
		}
		
		out.println(ans);
		//code ends here
		out.flush();
	}

	//helper functions
}
