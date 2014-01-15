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
		int test = Integer.parseInt(in.readLine().trim());

		while(test -- > 0) {
			String str = in.readLine();
			if (str.contains("010") || str.contains("101")){
				out.println("Good");
			} else{
				out.println("Bad");
			}
		}

		//code ends here
		out.flush();
	}

	//helper functions
}
