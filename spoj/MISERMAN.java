import java.util.*;
import java.math.*;
import java.text.*;
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

	// IO Imports
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		st = new StringTokenizer(in.readLine());
		int n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());

		int[][] a = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<m; j++) {
				a[i][j] = parseInt(st.nextToken());
			}
		}

		int dp[][] = new int[n][m];

		for(int i=0; i<m; i++) {
			dp[0][i] = a[0][i];
		}

		for(int i=1; i<n; i++) {
			for(int j=0; j<m; j++) {
				int tmp = Integer.MAX_VALUE;
				if(j > 0) {
					tmp = min(tmp, dp[i-1][j-1] + a[i][j]);
				}
				if(j < m - 1) {
					tmp = min(tmp, dp[i-1][j+1] + a[i][j]);
				}
				tmp = min(tmp, dp[i-1][j] + a[i][j]);
				dp[i][j] = tmp;
			}
		}

		int ans = Integer.MAX_VALUE;

		for(int i=0; i<m; i++) {
			ans = min(ans, dp[n-1][i]);
		}

		out.println(ans);
	}

	public Main() {
		this.in = new BufferedReader(new InputStreamReader(System.in));
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
