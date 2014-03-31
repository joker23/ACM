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
	// very similar to floyd :)
	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private int[][] dp, toll, time;

	public void solve() throws Exception {
		int n;
		int t;
		while((n = in.nextInt()) + (t = in.nextInt()) > 0 ){
			time = new int[n][n];
			toll = new int[n][n];

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					time[i][j] = in.nextInt();
				}
			}

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					toll[i][j] = in.nextInt();
				}
			}

			dp = new int[t + 1][n];

			for(int i=0; i<dp.length; i++) {
				fill(dp[i], 500000000);
			}
			for(int i=0; i<dp.length; i++){
				dp[i][0] = 0;
			}

			for(int k=0; k<t; k++){
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++) {
						if(k + time[i][j] <= t) {
							dp[k + time[i][j]][j] = min(dp[k + time[i][j]][j], dp[k][i] + toll[i][j]);
						}
					}
				}
			}

			int ans = 500000000;
			int time = 0;
			for(int i=0; i<dp.length; i++) {
				if(ans > dp[i][n-1]){
					ans = dp[i][n-1];
					time = i;
				}
			}

			out.println(ans + " " + time);
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
