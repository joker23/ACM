import java.util.*;
import java.math.*;
import java.io.*;
import java.awt.*;

public class Main/* extends Debug*/{
	
	//IO tools
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;

	//static variables
	static int[][] c, dp;

	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		//code starts here
		int t = Integer.parseInt(in.readLine().trim());

		while (t --> 0) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int rc = Integer.parseInt(st.nextToken());
			
			c = new int[n][m];
			dp = new int[n][m];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < m; j++) {
					c[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i=0; i< n; i++){
				Arrays.fill(dp[i], -1);
			}

			for(int i=0; i<m; i++){
				dp[0][i] = Math.min(Math.max(-1, rc - c[0][i]), 100);
			}

			for(int i=1; i<n; i++){
				for(int j=0; j<m; j++) {
					int max = -1;
					
					if(j > 0 && dp[i-1][j-1] > 0){
						max = Math.max(max, dp[i-1][j-1] - c[i][j]);
					}

					if(j < m-1 && dp[i-1][j+1] > 0){
						max = Math.max(max, dp[i-1][j+1] - c[i][j]);
					}
					
					dp[i][j] = Math.min(max,100);
				}
			}

			
			int ans = -100;
			for(int i=0; i<m ; i++){
				ans = Math.max(dp[n-1][i], ans);
			}
			
			//print(dp);

			out.println(ans);
		}

		//code ends here
		out.flush();
	}

	//helper functions
}
