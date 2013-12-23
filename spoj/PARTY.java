import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	// simple 01 knapsack

	//static Scanner in;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	public static void main(String[] args) throws IOException{
		//in = new Scanner(System.in);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		//code starts here
		int max, n;
		st = new StringTokenizer(in.readLine());
		while((max = Integer.parseInt(st.nextToken())) + (n = Integer.parseInt(st.nextToken())) > 0){
			
			int dp[] = new int[max+1];
			Arrays.fill(dp, -1);
			dp[0] = 0;
	
			int resCost = 0;
			int resFun = 0;
			while(n --> 0) {
				st = new StringTokenizer(in.readLine());
				int cost = Integer.parseInt(st.nextToken());
				int fun = Integer.parseInt(st.nextToken());

				for(int i=max ; i>= cost ; i--){
					if(dp[i-cost] != -1){
						dp[i] = Math.max(dp[i], dp[i-cost] + fun);
					}
				}
			}

			for(int i=1; i<dp.length; i++){
				if(dp[i] > resFun){
					resFun = dp[i];
					resCost = i;
				}
			}

			System.out.print(resCost + " ");
			System.out.println(resFun);

			in.readLine();
			st = new StringTokenizer(in.readLine());
		}
		//code ends here
		out.flush();
	}
}
