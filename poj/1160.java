import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;
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

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");
	private int inf = 99999999;


	public void solve() throws Exception {
		while(in.hasNextInt()) {
			int n = in.nextInt();
			int p = in.nextInt();

			int[] arr = new int[n];

			for(int i=0; i<n; i++) {
				arr[i] = in.nextInt();
			}

			int[][] sum = new int[n][n]; //if i placed a post between i and j

			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					sum[i][j] = sum[i][j-1] + arr[j] - arr[(i + j)/2];
				}
			}

			int[][] dp = new int[n][n];

			for(int i=0; i<n; i++) {
				dp[i][0] = sum[0][i]; //base case is when you place the ith post on the ith city
			}

			for (int j = 1; j < p; j++) {
				for (int i = j + 1; i < n; i++) {
					dp[i][j] = inf;
					for (int k = j - 1; k < i; k++) {
						dp[i][j] = min(dp[i][j], dp[k][j - 1] + sum[k + 1][i]);
					}
				}
			}

			out.println(dp[n-1][p-1]);
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
