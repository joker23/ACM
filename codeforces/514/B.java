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

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int n = in.nextInt();
		Point origin = new Point(in.nextInt(), in.nextInt());

		boolean[] vis = new boolean[n];
		Point[] list = new Point[n];

		for (int i=0; i<n; i++) {
			list[i] = new Point(in.nextInt(), in.nextInt());
		}

		int ans = 0;
		for (int i = 0; i<n; i++) {
			if (!vis[i]) {
				ans ++;
				for (int j = i; j<n; j++) {
					if (sameLine(new Point[]{origin, list[i], list[j]})){
						vis[j] = true;
					}
				}
			}
		}

		out.println(ans);
	}


	private boolean sameLine(Point[] p) {
		Arrays.sort(p, new Comparator<Point>() {
			public int compare(Point a, Point b) {
				return a.x - b.x;
			}
		});

		int c = (p[2].y - p[0].y) * (p[1].x - p[0].x);
		int d = (p[2].x - p[0].x) * (p[1].y - p[0].y);

		return c == d;
	}

	public B() {
		this.in = new Scanner(System.in);
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
		B solver = new B();
		solver.solve();
		solver.end();
	}
}
