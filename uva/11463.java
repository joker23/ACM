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
	private final static int inf = Integer.MAX_VALUE;

	public void solve() throws Exception {
		int t = parseInt(in.readLine().trim());
		for(int test=1; test<=t; test++) {
			int n = parseInt(in.readLine().trim());
			int r = parseInt(in.readLine().trim());
			graph = new int[n][n];

			for(int i=0; i<n; i++){
				fill(graph[i], inf);
			}

			for(int i=0; i<n; i++){
				graph[i][i] = 0;
			}

			while(r --> 0) {
				st = new StringTokenizer(in.readLine());
				int u = parseInt(st.nextToken());
				int v = parseInt(st.nextToken());

				graph[u][v] = 1;
				graph[v][u] = 1;
			}
			st = new StringTokenizer(in.readLine());
			int s = parseInt(st.nextToken());
			int d = parseInt(st.nextToken());

			for(int k = 0; k < n; k++){
				for(int i=0; i<n; i++){
					if(graph[i][k] < inf) {
						for(int j=0; j<n; j++) {
							if(graph[k][j] < inf) {
								graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
							}
						}
					}
				}
			}

			//print(graph);

			int res = 0;

			for(int i=0; i<n; i++) {
				if(graph[s][i] < inf && graph[i][d] < inf) {
					res = max (res, graph[s][i] + graph[i][d]);
				}
			}

			out.println("Case " + test + ": " + res);
		}
	}

	private void print(int[][] dp) {
		for(int i=0; i<dp.length; i++){
			for(int j=0; j<dp[i].length; j++){
				System.out.print("[" + dp[i][j] + "]");
			}System.out.println();
		}System.out.println();
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
