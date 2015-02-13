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
		int[] count = new int[4];

		for (int i=0; i<4; i++) {
			int num = in.readLine().length() - 2;
			count[i] = num;
		}

		int ans = -1;

		for (int i=0; i<4; i++) {
			int testNum = count[i];

			int greater = 0;
			int less = 0;

			for (int j=0; j<4; j++) {
				if (j != i) {
					if (testNum * 2 <= count[j]) {
						greater ++;
					}

					if (testNum/2 >= count[j]) {
						less ++;
					}
				}
			}

			if ((greater == 3 || less == 3)) {
				if (ans == -1) ans = i;
				else {
					out.println("C");
					return;
				}
			}
		}
		if (ans == -1) {
			out.println("C");
			return;
		}

		out.println((char) ('A' + ans));
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
