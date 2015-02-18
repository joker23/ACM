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
		String str = in.next();

		String rev = "";
		for (int i=0; i<str.length(); i++) {
			rev += (char) ('9' - str.charAt(i) + '0');
		}

		String ans = "";

		for (int i=0; i<str.length(); i++) {
			if (i == 0 && (str.charAt(i) == '0' || rev.charAt(i) == '0')) {
				ans += '9';
			} else if (str.charAt(i) < rev.charAt(i)) {
				ans += str.charAt(i);
			} else {
				ans += rev.charAt(i);
			}
		}
		out.println(ans);
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
