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

		while (t --> 0){
			st = new StringTokenizer(in.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			out.println((gcd(Math.abs(x1 - x2), Math.abs(y1 - y2)) - 1));
		}

		//code ends here
		out.flush();
	}

	//helper functions
	
	private static int gcd(int a, int b){
		return (b == 0 ? a : gcd(b, a%b));
	}
}
