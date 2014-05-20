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

public class Main {

	// IO Imports
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int test = parseInt(in.readLine().trim());

		while(test --> 0) {
			char[] arr = in.readLine().toCharArray();
			int dx = 0,
				dy = 0,
				var = 0;

			for(char c: arr) {
				switch (c) {
					case 'R':
						dx++;
						break;
					case 'L':
						dx--;
						break;
					case 'U':
						dy++;
						break;
					case 'D':
						dy--;
						break;
					default:
						var++;
				}
			}

			out.println((dx - var) + " " +
					(dy - var) + " " +
					(dx + var) + " " +
					(dy + var));
		}
	}

	public Main() {
		this.in = new BufferedReader(new InputStreamReader(System.in));
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
