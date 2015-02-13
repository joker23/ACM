package round501B;
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
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int n = Integer.parseInt(in.readLine());
		
		int[] degree = new int[n];
		int[] xorsum = new int[n];
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			degree[i] = Integer.parseInt(st.nextToken());
			xorsum[i] = Integer.parseInt(st.nextToken());
			
			if (degree[i] == 1) {
				q.add(i);
			}
		}
		
		List<Point> ans = new ArrayList<Point>();
		
		while (!q.isEmpty()) {
			int from = q.poll();
			if (degree[from] == 0) {
				continue;
			}
			int to = xorsum[from];
			xorsum[from] = 0;
			
			xorsum[to] ^= from;
			degree[to] --;
			if (degree[to] == 1) {
				q.add(to);
			}
			
			ans.add(new Point(from, to));
		}
		
		out.println(ans.size());
		
		for (Point p: ans) {
			out.println(p.x + " " + p.y);
		}
	}

	public C() {
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
		C solver = new C();
		solver.solve();
		solver.end();
	}
}

