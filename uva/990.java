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
		int maxt = in.nextInt();
		int w = in.nextInt();

		int n = in.nextInt();
		int dp[] = new int[maxt + 1];
		int set[] = new int[maxt + 1];

		fill(dp, -1);
		dp[0] = 0;

		int[] darr = new int[n];
		int[] warr = new int[n];

		for(int i=0; i<n; i++) {
			int d = in.nextInt();
			int v = in.nextInt();

			darr[i] = d;
			warr[i] = v;

			int t = 3*w*d;

			for(int j=maxt; j >= t; j--) {
				if(dp[j - t] > -1)
					if(dp[j] < dp[j - t] + v) {
						dp[j] = dp[j - t] + v;
						set[j] = set[j - t] + (1 << i);
					}
			}
		}

		int maxans = 0;
		int maxind = 0;

		for(int i=0; i<maxt; i++) {
			if(maxans < dp[i]) {
				maxans = dp[i];
				maxind = i;
			}
		}

		out.println(maxans);

		int count = 0;
		for(int i = 0; i<n; i++) {
			int s = set[maxind];

			if((s & 1<<i) > 0) {
				count ++;
			}
		}

		out.println(count);

		for(int i=0; i<n + 1; i++) {
			int s = set[maxind];
			if ((s & 1<<i) > 0) {
				out.println(darr[i] + " " + warr[i]);
			}
		}

		if(in.hasNext()) {
			out.println();
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
		while(solver.in.hasNext()) {
			solver.solve();
		}

		solver.end();
	}
}
