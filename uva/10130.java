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
		int t = parseInt(in.readLine().trim());

		while(t --> 0) {
			int n = parseInt(in.readLine().trim());
			int w[] = new int[n];
			int v[] = new int[n];

			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				v[i] = parseInt(st.nextToken());
				w[i] = parseInt(st.nextToken());
			}

			int[] dp = new int[31];
			fill(dp, -1);

			dp[0] = 0;

			for(int i=0; i<n; i++) {
				int tmp = w[i];
				for(int j=30; j >= tmp; j--) {
					if(dp[j - tmp] != -1) {
						dp[j] = max(dp[j], dp[j - tmp] + v[i]);
					}
				}
			}
			n = parseInt(in.readLine().trim());

			int ans = 0;
			while(n --> 0) {
				int tmp = parseInt(in.readLine().trim());

				int ms = 0;

				for(int i=tmp; i>=0; i--) {
					if(dp[i] != -1) {
						ms = max(ms, dp[i]);
					}
				}

				ans += ms;
			}
			out.println(ans);
		}
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
