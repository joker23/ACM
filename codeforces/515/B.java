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

public class B {

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int n = in.nextInt();
		int m = in.nextInt();

		boolean[] boy = new boolean[n];
		boolean[] girl = new boolean[m];

		int tmp = in.nextInt();

		for (int i=0; i<tmp; i++) {
			boy[in.nextInt()] = true;
		}

		tmp = in.nextInt();
		for (int i=0; i<tmp; i++) {
			girl[in.nextInt()] = true;
		}

		// LOL bellman idea
		for (int i=0; i<100*100*5; i++) {
			boolean happy = boy[i % n] || girl[i % m];
			if (happy) {
				boy[i % n] = true;
				girl[i % m] = true;
			}
		}

		boolean possible = true;
		for (boolean b : boy) {
			possible &= b;
		}

		for (boolean b : girl) {
			possible &= b;
		}

		if (possible) {
			out.println("YES");
		} else {
			out.println("NO");
		}
	}

	public B() {
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
		B solver = new B();
		solver.solve();
		solver.end();
	}
}
