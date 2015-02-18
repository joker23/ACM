
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

public class B {

	// IO Imports
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		// map new to old
		HashMap<String, String> map = new HashMap<String, String>();

		int n = Integer.parseInt(in.readLine());

		for (int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());

			String a = st.nextToken();
			String b = st.nextToken();

			if (!map.containsKey(a)) {
				map.put(b, a);
			} else {
				String c = map.remove(a);
				map.put(b, c);
			}
		}

		out.println(map.size());

		for (String s : map.keySet()) {
			out.println(map.get(s) + " " +s);
		}
	}

	public B() {
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
		B solver = new B();
		solver.solve();
		solver.end();
	}
}

