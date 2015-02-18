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

public class CHEFEQ {

	// IO Imports
	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int[] count = new int[100001];
		
		int t = in.nextInt();
		
		while (t --> 0) {
			Arrays.fill(count, 0);
			int n = in.nextInt();
			int m = 0;
			for (int i=0; i<n; i++) {
				int tmp = in.nextInt();
				
				count[tmp] ++;
				m = Math.max(count[tmp], m);
			}
			
			out.println(n - m);
		}
	}

	public CHEFEQ() {
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
		CHEFEQ solver = new CHEFEQ();
		solver.solve();
		solver.end();
	}
}

