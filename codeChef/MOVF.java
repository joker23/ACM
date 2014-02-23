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
	static int[] cost;
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		//code starts here
		int t = Integer.parseInt(in.readLine().trim());
	
		while(t --> 0){
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			cost = new int[n];
			for(int i=0; i < n; i++){
				in.readLine(); //trashing
				cost[i] = Integer.parseInt(in.readLine().trim());
			}
			
			long ans = 0;
			for (int a = 0; a < n; a++){
				for (int b = a + 1; b < n; b++){
					for (int c = b + 1; c < n; c++) {
						if (cost[a] + cost[b] + cost[c] == k) {
							ans ++;
						}
					}
				}
			}

			out.println(ans);
		}

		//code ends here
		out.flush();
	}

	//helper functions
}
