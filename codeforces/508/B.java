package r288B;

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

	// IO Imports
	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		char[] n = in.next().trim().toCharArray();
		
		int len = n.length - 1;
		int count_evens = 0;
		int last = -1;
		boolean found = false;
		
		for (int i=0; i<len; i++) {
			int num = n[i] - '0';
			if ((num & 1) == 0) {
				count_evens ++;
				last = i;
				if (n[i] < n[len]) {
					char tmp = n[len];
					n[len] = n[i];
					n[i] = tmp;
					found = true;
					break;
				}
			}
		}
		
		if (!found && last > -1) {
			char tmp = n[len];
			n[len] = n[last];
			n[last] = tmp;
		}
		
		if (count_evens == 0) {
			out.println(-1);
		} else {
			out.println(String.valueOf(n));
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
		} catch (Exception e) {
			//do nothing then :)
		}
	}

	public static void main(String[] args) throws Exception {
		B solver = new B();
		solver.solve();
		solver.end();
	}
}

