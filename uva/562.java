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
		int t = in.nextInt();

		while (t --> 0) {
			int n = in.nextInt();
			int[] arr = new int[n];
			int sum = 0;

			for (int i=0; i<n; i++) {
				arr[i] = in.nextInt();
				sum += arr[i];
			}

			boolean[] dp = new boolean[(sum/2) + 1];
			dp[0] = true;

			for (int i : arr) {
				for(int j=dp.length - 1; j>=i; j--) {
					if (dp[j - i]) {
						dp[j] = true;
					}
				}
			}

			int half = 0;

			for (int i=0; i<dp.length; i++) {
				if (dp[i]) {
					half = i;
				}
			}

			out.println(abs(sum - (2 * half)));
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
