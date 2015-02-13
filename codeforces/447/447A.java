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
		int p = in.nextInt();
		int n = in.nextInt();

		out.println(problem(n, p));
	}

	public int problem(int n, int p) {
		boolean[] vis = new boolean[500];
		fill(vis, false);

		int ret = -1;
		boolean found = false;
		for (int i=0; i<n; i++) {
			int temp = in.nextInt() % p;

			if (found) continue;
			if (vis[temp]) {
				ret = i + 1;
				found = true;
			} else {
				vis[temp] = true;
			}
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
