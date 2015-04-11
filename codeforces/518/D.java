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

public class D {

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int n = in.nextInt();
		double p = in.nextDouble();
		int t = in.nextInt();

		double[][] dp = new double[t + 1][n + 1];
		dp[0][0] = 1;

		for (int i=1; i<=t; i++) {
			dp[i][0] = dp[i-1][0] * (1 - p);
		}

		for (int i=1; i<=t; i++) {
			for (int j=1; j<=i && j<=n; j++) {
				if (j == n) {
					dp[i][j] = dp[i-1][j] + (dp[i-1][j-1] * p);
				} else {
					dp[i][j] = (dp[i-1][j] * (1- p)) + (dp[i-1][j-1] * p);
				}
			}
		}

		double ans = 0;
		for (int i=1; i<=n; i++) {
			ans += dp[t][i] * i;
		}

		out.println(ans);
	}

	public D() {
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
		D solver = new D();
		solver.solve();
		solver.end();
	}
}
