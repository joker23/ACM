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

	public void solve() throws Exception {
		int n = in.nextInt();
		int[] arr = new int[n];

		long sum = 0;
		for (int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			sum += arr[i];
		}

		if (sum % 3 != 0) {
			out.println(0);
		} else {
			long goal = sum / 3;
			int[] dp = new int[n];
			long tmp = 0;

			for (int i=0; i<n; i++) {
				tmp += arr[i];
				if (tmp == goal) {
					dp[i] = 1;
				}
			}

			for (int i=1; i<n; i++) {
				dp[i] += dp[i-1];
			}

			tmp = 0;
			long ans = 0;
			for (int i=n-1; i>1; i--) {
				tmp += arr[i];
				if (tmp == goal) {
					ans += dp[i-2];
				}
			}
			out.println(ans);
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
