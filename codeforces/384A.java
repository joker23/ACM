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
		
		boolean n1, n2;
		int res = 0;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				n1 = i%2 == 0;
				n2 = j%2 ==0;	
				if(!(n1^n2)){
					res ++;
				}
			}
		}

		out.println(res);

		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				n1 = i%2 == 0;
				n2 = j%2 ==0;	
				if(!(n1^n2)){
					out.print('C');
				}
				else{
					out.print('.');
				}
			}
			out.println();
		}

		//code ends here
		out.flush();
	}

	//helper functions
}
