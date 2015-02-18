 package practice;
import java. util.*;
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

public class MARBLES {

	// IO Imports
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int t = Integer.parseInt(in.readLine());
		
		while (t --> 0) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			out.println(c(n - 1, k - 1));
		}
	}
	
	private BigInteger c (int n, int k) {
		k = Math.min(k, n-k);
		BigInteger ret = BigInteger.ONE ;
		for (int i=n-k+1; i<=n; i++)
			ret = ret.multiply(BigInteger.valueOf(i));
		for ( int i=2; i<=k; i++)
			ret = ret.divide(BigInteger.valueOf(i));
		return ret ;
	}

	public MARBLES() {
		this.in = new BufferedReader(new InputStreamReader(System.in));
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
		MARBLES solver = new MARBLES();
		solver.solve();
		solver.end();
	}
}

