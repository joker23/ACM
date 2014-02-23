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
		int t = Integer.parseInt(in.readLine().trim());

		while (t --> 0) {
			int n = Integer.parseInt(in.readLine().trim());
			if(n%2 == 0){
				out.println("Valar Morghulis");
			} else {
				out.println("Lannisters always pays their debts");
			}
		}

		//code ends here
		out.flush();
	}

	//helper functions
}
