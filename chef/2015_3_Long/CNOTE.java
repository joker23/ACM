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
		int t = parseInt(in.readLine());

		while (t --> 0) {
			st = new StringTokenizer(in.readLine());
			int m = parseInt(st.nextToken()) - parseInt(st.nextToken());
			int k = parseInt(st.nextToken());
			int n = parseInt(st.nextToken());

			boolean ans = m <= 0;

			while (n --> 0) {
				st = new StringTokenizer(in.readLine());
				int p = parseInt(st.nextToken());
				int c = parseInt(st.nextToken());

				if (p >= m && c <= k) {
					ans = true;
				}
			}

			if (ans) {
				out.println("LuckyChef");
			} else {
				out.println("UnluckyChef");
			}
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
