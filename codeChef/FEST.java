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
		BigInteger mod = new BigInteger("1000000007");

		while (t --> 0){
			st = new StringTokenizer(in.readLine());

			BigInteger a = new BigInteger(st.nextToken());
			a = a.modPow(new BigInteger(st.nextToken()), mod);

			out.println(a);
		}

		//code ends here
		out.flush();
	}

	//helper functions
}
