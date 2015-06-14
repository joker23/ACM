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

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int n = in.nextInt();
		int k = 0;
		String ans = "";

		if (n <= 2) {
			k = 1;
			ans = "1";
		} else if (n == 3) {
			k = 2;
			ans = "1 3";
		} else if (n == 4) {
			k = 4;
			ans = "3 1 4 2";
		} else {
			k = n;
			ArrayList<Integer> odd = new ArrayList<Integer>();
			ArrayList<Integer> even = new ArrayList<Integer>();

			for (int i=1; i<=n; i++) {
				if (i % 2 == 0) {
					even.add(i);
				} else {
					odd.add(i);
				}
			}

			while (!odd.isEmpty()) {
				ans += odd.remove(0) + " ";
			}

			while (!even.isEmpty()) {
				ans += even.remove(0) + " ";
			}
		}

		out.println(k);
		out.println(ans.trim());
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
		} catch (Exception e){
			//do nothing then :)
		}
	}

	public static void main(String[] args) throws Exception {
		A solver = new A();
		solver.solve();
		solver.end();
	}
}
