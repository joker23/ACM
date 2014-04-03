import java.util.*;
import java.math.*;
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

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private int[] set;
	public void solve() throws Exception {
		int n, m;
		while((n =in.nextInt()) + (m =in.nextInt()) > 0) {
			Edge[] edges = new Edge[m];

			for(int i=0; i < m; i++ ) {
				edges[i] = new Edge(in.nextInt(), in.nextInt(), in.nextInt());
			}

			sort(edges);

			set = new int[n + 1];

			for(int i=0; i<=n; i++) {
				set[i] = i;
			}
			int[][] cache = new int[n+1][n+1];
			int ans = 0;

			for(int i=0; i<m; i++) {
				int u = edges[i].u;
				int v = edges[i].v;
				int w = edges[i].w;

				if(find(u) != find(v)){
					ans += w;
					join(u, v);
				} else {
					cache[u][v] = max(cache[u][v], w);
				}
			}

			LinkedList<Integer> list = new LinkedList<Integer>();

			for(int i=0; i<cache.length; i++) {
				for(int j=0; j<cache[i].length; j++){
					if(cache[i][j] > 0) {
						list.add(cache[i][j]);
					}
				}
			}

			if(list.isEmpty()) {
				out.println("forest");
			} else {
				sort(list);

				out.print(list.poll());
				while(!list.isEmpty()) {
					out.print(" " + list.poll());
				}out.println();
			}
		}
	}

	public int find(int a) {
		if(set[a] == a) {
			return a;
		} set[a] = find(set[a]);
		return set[a];
	}

	public void join(int a, int b) {
		set[find(a)] = find(b);
	}

	public class Edge implements Comparable<Edge>{
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
