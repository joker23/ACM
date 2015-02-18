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

	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		String str = in.readLine();
		int n = str.length();

		int t = Integer.parseInt(in.readLine());

		int[][] dp = new int[26][n];

		dp[str.charAt(0) - 'a'][0] = 1;

		for (int i=1; i<n; i++) {
			for (int j = 0;  j< 26;j++) {
				if (str.charAt(i) == 'a' + j) {
					dp[j][i] = dp[j][i - 1] + 1;
				} else {
					dp[j][i] = dp[j][i - 1];
				}
			}
		}

		while (t --> 0) {
			st = new StringTokenizer(in.readLine());
			char a = st.nextToken().toCharArray()[0];
			char b = st.nextToken().toCharArray()[0];

			int l = parseInt(st.nextToken()) - 1;
			int r = parseInt(st.nextToken()) - 1;

			int ans = 0;
			for (int i=l; i <=r; i++) {
				if (str.charAt(i) == a) {
					ans += dp[b - 'a'][r] - dp[b - 'a'][i];
				}
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
