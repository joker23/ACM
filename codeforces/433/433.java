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
		int[] a = new int[n];
		int sum = 0;

		for(int i=0; i<n; i++) {
			a[i] = in.nextInt();
			sum += a[i];
		}

		sum /= 2;

		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;

		for(int tmp : a) {
			for(int i=sum; i>= tmp; i--) {
				if(dp[i - tmp]) {
					dp[i] = true;
				}
			}
		}

		String ans = dp[sum] ? "YES" : "NO";
		out.println(ans);
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
