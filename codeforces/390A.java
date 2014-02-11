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
		int n = Integer.parseInt(in.readLine().trim());

		boolean[] x = new boolean[101];
		boolean[] y = new boolean[101];

		while(n --> 0){
			st = new StringTokenizer(in.readLine());
			x[Integer.parseInt(st.nextToken())] = true;
			y[Integer.parseInt(st.nextToken())] = true;
		}

		int xcount = 0;
		int ycount = 0;

		for(int i=0; i<x.length; i++){
			if(x[i]){
				xcount ++;
			}
			if(y[i]){
				ycount ++;
			}
		}

		out.println(Math.min(xcount, ycount));

		//code ends here
		out.flush();
	}

	//helper functions
}
