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
		char[] n = in.next().trim().toCharArray();
		int[] ans = new int[100];

		int a2 = 0;
		int p = 0;
		for (int i=n.length - 1; i>=0; i--) {
			int t = n[i] - '0';
			a2 = max(a2, t);
			for (int j = 0; j<t; j++) {
				ans[j] += pow(10, p);
			}

			p ++;
		}

		out.println(a2);

		int ptr = 0;
		String o = "";
		while(ans[ptr] > 0) {
			o += ans[ptr++] + " ";
		}

		out.println(o.trim());
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
