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
		st = new StringTokenizer(in.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		while(n-->0){
			String tmp = in.readLine(); //throw it away man
		}
		int tot = m*(m-1)/2;
		out.println(tot);

		if(k == 0){
			for(int i=1; i<m; i++){
				for(int j=i+1; j<=m; j++){
					out.println(i + " " + j);
				}
			}
		} else {
			for(int i=1; i<m; i++){
				for(int j=m; j>i; j--){
					out.println(j + " " + i);
				}
			}
		}

		//code ends here
		out.flush();
	}

	//helper functions
}
