import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	//IO tools
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;

	//static variables
	static int l,d,s,c;

	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		//code starts here
		int test = Integer.parseInt(in.readLine());

		while(test --> 0) {
			st = new StringTokenizer(in.readLine());
			l = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			boolean alive = true;

			if(d == 1){
				alive = s>=l;
			} else{
				double min = ((double) l)/s;
				alive = Math.pow(min, 1.0/(d-1)) <= c+1;
			}
			if(alive){
				out.println("ALIVE AND KICKING");
			} else {
				out.println("DEAD AND ROTTING");
			}
		}

		//code ends here
		out.flush();
	}

	//helper functions
}
