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
		st = new StringTokenizer(in.readLine());

		boolean crash = false;
		int height = 168;
		int test = -1;
		while(!crash && st.hasMoreTokens()){
			test = Integer.parseInt(st.nextToken());
			if(test<height){
				crash = true;
			}
		}

		if(crash){
			out.println("CRASH "+test);
		} else{
			out.println("NO CRASH");
		}
		//code ends here
		out.flush();
	}

	//helper functions
}
