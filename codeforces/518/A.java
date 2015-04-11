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
		String s = in.next();
		String t = in.next();

		int ptr = s.length() - 1;
		while (s.charAt(ptr) == 'z') {
			s = s.substring(0,ptr) + 'a' + s.substring(ptr + 1, s.length());
			ptr--;
		}

		char rep = (char)(s.charAt(ptr) + 1);
		s = s.substring(0, ptr) + rep + s.substring(ptr + 1, s.length());

		if (s.compareTo(t) < 0) {
			out.println(s);
		} else {
			out.println("No such string");
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
