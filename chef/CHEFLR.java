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
	private int mod = 1000000007;

	public void solve() throws Exception {
		int t = parseInt(in.readLine().trim());

		while (t --> 0) {
			char[] path = in.readLine().toCharArray();

			int ans = path[0] == 'l' ? 2 : 4;

			for (int i=1; i<path.length; i++) {
				char move = path[i];
				ans *= 2;

				if (i % 2 == 1) {
					ans += (move == 'l' ? -1 : 1);
				} else {
					ans += (move == 'l' ? 0 : 2);
				}

				ans = ans % mod;
			}
			out.println(ans);
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
