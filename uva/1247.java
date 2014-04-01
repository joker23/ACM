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

	private int[][] graph;
	private int[][] prev;

	private int inf = 1000000000;

	public void solve() throws Exception {
		st = new StringTokenizer(in.readLine());
		int n = parseInt(st.nextToken());
		int p = parseInt(st.nextToken());
		graph = new int[n][n];

		for(int i=0; i<n; i++) {
			fill(graph[i], inf);
		}
		prev = new int[n][n];
		for(int i=0; i<n; i++) {
			fill(prev[i], -1);
		}


		while(p --> 0) {
			String[] str = in.readLine().split(" ");
			int u = str[0].charAt(0) - 'A';
			int v = str[1].charAt(0) -  'A';
			int w = parseInt(str[2]);
			graph[u][v] = w;
			graph[v][u] = w;
			prev[u][v] = u;
			prev[v][u] = v;
		}

		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++){
				if(graph[i][k] < inf){
					for(int j=0; j<n; j++) {
						if(graph[k][j] < inf) {
							if(graph[i][j] > graph[i][k] + graph[k][j]) {
								graph[i][j] = graph[i][k] + graph[k][j];
								prev[i][j] = prev[k][j];
							}
						}
					}
				}
			}
		}

		int q = parseInt(in.readLine().trim());

		while(q --> 0) {
			st = new StringTokenizer(in.readLine());

			int from = st.nextToken().charAt(0) - 'A';
			int to = st.nextToken().charAt(0) - 'A';

			String ans = from + path(from, to) + to;
			st = new StringTokenizer(ans);
			out.print((char) (parseInt(st.nextToken()) + 'A'));
			while(st.hasMoreTokens()) {
				out.print(" " + (char) (parseInt(st.nextToken()) + 'A'));
			}
			out.println();
		}
	}

	private String path(int i, int j) {
		if(prev[i][j] == inf) {
			return "";
		}
		int next = prev[i][j];
		if(next == i) {
			return " "; //directed edge from i to j is shortest
		} else {
			return path(i, next) + next + path(next, j);
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
