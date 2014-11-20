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

	public void solve() throws Exception {
		int n = in.nextInt();

		int[][] dp = new int[n][n];
		int[] temp = new int[n];

		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				dp[i][j] = in.nextInt();
			}
		}

		int maxEnd;
		int curr;
		int max = Integer.MIN_VALUE;

		for (int i=0; i<n; i++) {
			Arrays.fill(temp, 0);
			for (int j=i; j<n; j++) {
				maxEnd = 0;
				curr = Integer.MIN_VALUE;
				for (int k=0; k<n; k++) {
					temp[k] += dp[j][k];
					maxEnd = Math.max(0, maxEnd + temp[k]);
					curr = Math.max(curr, maxEnd);
				}
				max = Math.max(max, curr);
			}
		}
		out.println(max);
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
