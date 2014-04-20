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

public class Main {

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private int inf = 1000010;
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");


	public void solve() throws Exception {
		int n = in.nextInt();
		int ml = in.nextInt();
		int md = in.nextInt();

		Edge[] graph = new Edge[n + ml + md - 1];

		int count = 0;

		// going backwards costs nothing!
		for(int i=1; i<n; i++) {
			graph[count++] = new Edge(i + 1, i, 0);
		}

		while(ml --> 0) {
			graph[count++] = new Edge(in.nextInt(), in.nextInt(), in.nextInt());
		}

		while(md --> 0) {
			int u = in.nextInt();
			int v = in.nextInt();

			graph[count++] = new Edge(v, u, - in.nextInt());
		}

		out.println(bellman(graph, 1, n, n));

	}

	public int bellman(Edge[] graph, int start, int end, int n) {
		int dist[] = new int[n+1];
		fill(dist, inf);
		dist[start] = 0;

		for(int i=1; i<=n; i++) {
			for(Edge e: graph) {
				dist[e.v] = min(dist[e.u] + e.w, dist[e.v]);
			}
		}

		if(hasNegCycle(graph, dist, end)) {
			return -1;
		} else if(dist[end] == inf){
			return  -2;
		} else {
			return dist[end];
		}
	}

	public boolean hasNegCycle(Edge[] graph, int[] dist, int end) {
		int curr = dist[end];

		for(Edge e: graph) {
			dist[e.v] = min(dist[e.u] + e.w, dist[e.v]);
		}

		return dist[end] < curr;
	}

	public class Edge implements Comparable<Edge> {
		int u, v, w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		public int compareTo(Edge e) {
			return this.w - e.w;
		}
	}

	public Main() {
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
		Main solver = new Main();
		solver.solve();
		solver.end();
	}
}
