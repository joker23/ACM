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
		while(t --> 0){
			st = new StringTokenizer(in.readLine());

			int n = Integer.parseInt(st.nextToken());
			int minS = Integer.parseInt(st.nextToken());
			int minR = Integer.parseInt(st.nextToken());

			int rcut = 0;
			while(n --> 0){
				st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				if (s > minS || r > minR) {
					rcut ++;
				}
			}

			int a = Integer.parseInt(in.readLine().trim());

			int fact = gcd(rcut, a);

			int numerator = rcut/fact;
			int denom = a/fact;

			if(denom == 1){
				out.println(numerator);
			} else if(numerator == 0){
				out.println(0);
			} else {
				out.println(numerator + "/" + denom);
			}
		}

		//code ends here
		out.flush();
	}

	//helper functions
	private static int gcd(int a, int b){
		return (b == 0 ? a : gcd(b, a%b));
	}
}
