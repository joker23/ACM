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
		char[] s = in.next().toCharArray();
		char[] t = in.next().toCharArray();
		boolean[] vis = new boolean[s.length];

		int[] count = new int[Character.MAX_VALUE];

		for (char c : t) {
			count[c] ++;
		}

		int yay = 0;
		for (int i=0; i<s.length; i++) {
			char c = s[i];
			if (count[c] > 0) {
				count[c] --;
				vis[i] = true;
				yay++;
			}
		}

		int other = 0;
		for (int i=0; i<s.length; i++) {
			char c = s[i];
			if (!vis[i]) {
				if (c < 'a') {
					//caps
					int tmp = c + 32;
					if (count[tmp] > 0) {
						count[tmp] --;
						other ++;
					}
				} else {
					int tmp = c - 32;
					if (count[tmp] > 0) {
						count[tmp] --;
						other ++;
					}
				}
			}
		}

		out.println(yay + " " + other);
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
