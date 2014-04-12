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

	private int[][] graph;
	private int s,t;
	private HashMap<String, Integer> map;
	public void solve() throws Exception {
		int test = in.nextInt();

		map = new HashMap<String, Integer>();

		map.put("XS", 1);
		map.put("S", 2);
		map.put("M", 3);
		map.put("L", 4);
		map.put("XL", 5);
		map.put("XXL",6);

		s = 0;

		while(test --> 0) {
			int n = in.nextInt();
			int m = in.nextInt();

			graph = new int[6 + m + 2][6 + m + 2];
			t = graph.length - 1;

			for(int i = 1; i<=6; i++) {
				graph[0][i] = n / 6;
			}

			for(int i = 1; i<=m; i++) {
				graph[i+6][t] = 1;
			}

			for(int i=1; i<=m; i++) {
				int u = map.get(in.next());
				int v = map.get(in.next());

				graph[u][i+6] ++;
				graph[v][i+6] ++;
			}

			int flow = maxFlow();

			if(m <= flow){
				out.println("YES");
			} else {
				out.println("NO");
			}
		}
	}

	public int maxFlow() {
		Queue<Integer> q;
		int[] prev = new int[graph.length];
		int ans = 0;
		while(true) {
			q = new LinkedList<Integer>();
			q.add(s);
			fill(prev, -1);
			while(!q.isEmpty() && prev[t] == -1){
				int u = q.remove();
				for(int v=0; v<graph.length; v++) {
					if(v != s && prev[v] == -1 && graph[u][v] > 0) {
						q.add(v);
						prev[v] = u;
					}
				}
			}

			if(prev[t] == -1) {
				break;
			}

			int mincut = Integer.MAX_VALUE;

			for(int v=t, u=prev[v]; u!=-1;v=u, u=prev[v]) {
				mincut = min(mincut, graph[u][v]);
			}
			for(int v=t, u=prev[v]; u!=-1;v=u, u=prev[v]) {
				graph[u][v] -= mincut;
				graph[v][u] += mincut;
			}
			ans += mincut;
		}
		return ans;
	}

	public void printGraph() {
		System.out.println();
		for(int i=0; i<graph.length; i++) {
			for(int j=0; j<graph.length; j++) {
				System.out.print("[" + graph[i][j] + "]");
			} System.out.println();
		}System.out.println();
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
