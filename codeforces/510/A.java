package r290B;

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

public class A {

	// IO Imports
	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int n = in.nextInt();
		int m = in.nextInt();
		
		char[][] ans = new char[n][m];
		boolean r = true;
		
		for (int i=0; i<n; i++) {
			Arrays.fill(ans[i], '.');
		}
		
		for (int i = 0; i<n; i++) {
			if ((i & 1) == 0) {
				Arrays.fill(ans[i], '#');
			} else {
				if (r) {
					ans[i][m - 1] = '#';
				} else {
					ans[i][0] = '#';
				}
				
				r = !r;
			}
		}
		
		for (int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				out.print(ans[i][j]);
			} out.println();
		}
	}

	public A() {
		this.in = new Scanner(System.in);
		this.out = new PrintWriter(System.out);
	}

	public void end() {
		try {
			this.out.flush();
			this.out.close();
			this.in.close();
		} catch (Exception e) {
			//do nothing then :)
		}
	}

	public static void main(String[] args) throws Exception {
		A solver = new A();
		solver.solve();
		solver.end();
	}
}

