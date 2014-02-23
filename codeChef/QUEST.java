import java.util.*;
import java.math.*;
import java.io.*;
import java.awt.*;

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

		int[] count = new int[Character.MAX_VALUE];
		
		for(char c : str){
			count[c] ++;
		}
		
		int odds = 0;
		for(int i = 0; i<count.length; i++){
			if(count[i] % 2 == 1){
				odds ++;
			}
		}


		if(odds > 1){
			out.println("NO");
		} else {
			out.println("YES");
		}

		//code ends here
		out.flush();
	}

	//helper functions
}
