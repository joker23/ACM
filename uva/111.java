import java.util.*;
import java.math.*;
import java.io.*;
import java.awt.Point;

import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Long.*;
import static java.lang.Short.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Collections.*;

public class Main {

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	public void solve() throws Exception {
		int n = in.nextInt();

		int[] ans = new int[n];
		for(int i=0; i<n; i++) {
			ans[in.nextInt() - 1] = i;
		}

		while( in.hasNextInt() ) {
			int[] query = new int[n];

			for(int i=0; i<n; i++) {
				query[in.nextInt() - 1] = i;
			}

			int[][] dp = new int[n][n];

			dp[0][0] = ans[0] == query[0] ? 1 : 0;
			for(int i=1; i<n; i++) {
				dp[i][0] = max(ans[i] == query[0] ? 1 : 0, dp[i-1][0]);
				dp[0][i] = max(ans[0] == query[i] ? 1 : 0, dp[0][i-1]);
			}

			for(int i=1; i<n; i++ ) {
				for(int j=1; j<n; j++) {
					if(ans[i] == query[j]) {
						dp[i][j] = dp[i-1][j-1] + 1;
					} else {
						dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}

			out.println(dp[n-1][n-1]);
		}
	}


	public Main() {
		this.in = new Scanner(System.in);
		this.out = new PrintWriter(System.out);
	}

	public void end() {
		try {
			this.out.flush();
			this.out.close();
			this.in.close();
		} catch (Exception e){
			//do nothing then :)
		}
	}

	public static void main(String[] args) throws Exception {
		Main solver = new Main();
		solver.solve();
		solver.end();
	}
}
