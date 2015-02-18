package practice;
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

public class COINS {

	// IO Imports
	private BufferedReader in;
	private StringTokenizer st;
	private Scanner sc;
	private PrintWriter out;
	private HashMap<Long, Long> dp;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		sc = new Scanner(System.in);
		dp = new HashMap<Long, Long>();
		
		while (sc.hasNext()) {
			long n = sc.nextLong();
			dp.clear();
			out.println(r(n));
		}
	}
	
	private long r(long n) {
		if (n == 0) {
			return 0;
		} else if(dp.containsKey(n)) {
			return dp.get(n);
		}else {
			long ret = Math.max(n, r(n/2) + r(n/3) + r(n/4));
			dp.put(n, ret);
			return ret;
		}
	}

	public COINS() {
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
		COINS solver = new COINS();
		solver.solve();
		solver.end();
	}
}

