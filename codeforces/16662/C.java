
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

public class C {

	// IO Imports
	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		long n = in.nextLong();
		long m = in.nextLong();
		
		long ans = 0;
		for (int i=0 ; i<=n; i++)  {
			long mLeft = m - 2*i;
			long nLeft = n - i;
			
			if (mLeft >= 0) {
				long offset = Math.min(mLeft, nLeft/2);
				ans = Math.max(i + offset, ans);
			}
		}
		
		out.println(ans);
	}

	public C() {
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
		C solver = new C();
		solver.solve();
		solver.end();
	}
}

