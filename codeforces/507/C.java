package r507B;
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

public class C {

	// IO Imports
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int n = sc.nextInt();

		int d = (int)ceil(abs(n - h) / 2.0);
		int offset = 0;

		System.out.println(d);
		if (n < h) {
			if (h % 2 == 0 && h - 1 != n) {
				offset = (h - 1) / 2;
			}

			if (h % 2 == 1) {
				offset = (h - 1) / 2;
			}
		}

		if (h % 2 == 0) { // (h+1) (h)

			if (d % 2 == 0) {
				if (n % 2 == 0) {
					out.println(h + (h * d) + (h * offset));
				} else {
					out.println(h + 1 + (h * d) + (h * offset));
				}
			} else {
				if (n % 2 == 1) {
					out.println(h + (h * d) + (h * offset));
				} else {
					out.println(h + 1 + (h * d) + (h * offset));
				}
			}

		} else { // (h) (h+1)
			if (n > h + 1) {
				d += (h - 1) / 2;
			}
		}

	}

	public C() {
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = new PrintWriter(System.out);
	}

	public void end() {
		try {
			this.out.flush();
			this.out.close();
			this.in.close();
		} catch (Exception e) {
			// do nothing then :)
		}
	}

	public static void main(String[] args) throws Exception {
		C solver = new C();
		solver.solve();
		solver.end();
	}
}
