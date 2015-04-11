
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

	// IO Imports
	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	private HashMap<Character, Integer> table;
	
	public void solve() throws Exception {
		table = new HashMap<Character, Integer>();
		
		table.put('Q', 9);
		table.put('R', 5);
		table.put('B', 3);
		table.put('N', 3);
		table.put('P', 1);
		table.put('K', 0);
		
		int white = 0;
		int black = 0;
		
		for (int i=0;i<8; i++) {
			char[] arr = in.next().toCharArray();
			for (char c : arr) {
				if (c != '.') {
					if (c < 'a') {
						white += table.get(c);
					} else {
						c -= 32;
						black += table.get((char) c);
					}
				}
			}
		}
		
		if (white > black) {
			out.println("White");
		} else if(black > white) {
			out.println("Black");
		} else {
			out.println("Draw");
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
		} catch (Exception e) {
			//do nothing then :)
		}
	}

	public static void main(String[] args) throws Exception {
		A solver = new A();
		solver.solve();
		solver.end();
	}
}

