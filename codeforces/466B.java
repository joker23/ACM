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
		long n = in.nextLong();
		long a = in.nextLong();
		long b = in.nextLong();

		long target = n * 6;
		if (a * b < target) {
			long small = min(a, b);
			long large = max(a, b);

			long best = Integer.MAX_VALUE;
			for(int i= (int) small; i<sqrt(target); i++) {
				long tmp = (long) ceil((double)target/i);

				if (best > abs(target - i * tmp) && tmp >= max(a, b) && i * tmp >= target) {
					small = i;
					large = tmp;
					best = abs(target - i * tmp);
				}
			}

			if (a < b) {
				a = small;
				b = large;
			} else {
				b = small;
				a = large;
			}
		}
		out.println(a * b);
		out.println(a + " " + b);
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
