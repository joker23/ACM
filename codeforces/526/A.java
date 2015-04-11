import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
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

		char[] lvl = in.next().toCharArray();

		for (int i=1; i<n; i++) {
			for (int j=0; j<n; j++) {
				int count = 0;
				for (int k = j; k<n; k+=i) {
					if (lvl[k] == '.') {
						break;
					} else {
						count ++;
					}

					if (count == 5) {
						out.println("yes");
						return;
					}
				}
			}
		}

		out.println("no");
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
