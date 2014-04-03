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

	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;
	private int[] set;

	public void solve() throws Exception {
		int t = parseInt(in.readLine().trim());
		for(int test = 1; test<=t; test ++) {
			int n = parseInt(in.readLine().trim());
			set = new int[n];
			for(int i=0; i<n; i++) {
				set[i] = i;
			}

			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine(), ", ");
				for(int j=0; j<n; j++) {
					int tmp = parseInt(st.nextToken());
					if(tmp > 0) {
						pq.add(new Edge(i, j, tmp));
					}
				}
			}

			LinkedList<Edge> list = new LinkedList<Edge>();

			Edge curr;
			while(!pq.isEmpty()) {
				curr = pq.poll();
				if(find(curr.u) != find(curr.v)) {
					list.add(curr);
					merge(curr.u, curr.v);
				}
			}

			sort(list);


			out.println("Case " + test + ":");
			while(!list.isEmpty()){
				out.println(list.poll());
			}
		}
	}

	public void merge(int a, int b) {
		set[find(a)] = find(b);
	}

	public int find(int a) {
		if(set[a] == a) {
			return a;
		} set[a] = find(set[a]);
		return set[a];
	}

	private class Edge implements Comparable<Edge> {
		int u, v, w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		public int compareTo(Edge e) {
			return this.w - e.w;
		}

		public String toString() {
			char c = (char)(u + 'A');
			char d = (char)(v + 'A');

			char first = (char)min(c,d);
			char last = (char)max(c,d);

			return first + "-" + last + " " + w;
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
