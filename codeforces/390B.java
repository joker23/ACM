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
		int n = Integer.parseInt(in.readLine());

		long[] a = new long[n];
		long[] b = new long[n];

		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++){
			a[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++){
			b[i] = Long.parseLong(st.nextToken());
		}
		
		long joy = 0;
		for(int i=0; i<n; i++){
			if(((b[i] + 1)/2)> a[i]){
				joy --;
			} else{
				joy += (b[i]/2) * ((b[i] + 1)/2);
			}
		}

		out.println(joy);

		//code ends here
		out.flush();
	}

	//helper functions
}
