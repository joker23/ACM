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

	private int[][] dp;

	public void solve() throws Exception {
		int n, k;
		while((n = in.nextInt()) + (k = in.nextInt()) > 0) {
			dp = new int[k+1][n+1];

			dp[0][0] = 1;

			List<Integer> primes = sieve(n);

			for(int p : primes) {
				for(int i = n; i >= p; i --) {
					for(int j = k; j > 0; j --) {
						dp[j][i] += dp[j - 1][i - p];
					}
				}
			}

			out.println(dp[k][n]);
		}
	}

	private List<Integer> sieve(int n) {
		boolean[] p = new boolean[n+1];
		fill(p, true);
		p[0] = p[1] = false;

		for(int i=2; i*i <= n; i++) {
			if(p[i]) {
				for(int j=i+i; j<=n; j+= i) {
					p[j] = false;
				}
			}
		}

		List<Integer> ret = new LinkedList<Integer>();

		for(int i=2; i<n + 1; i++) {
			if(p[i]) ret.add(i);
		}

		return ret;
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
