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

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	private LinkedList<Integer>[] graph;
	private int cc;
	private boolean[] vis;

	public void solve() throws Exception {
		int n = in.nextInt();
		int m = in.nextInt();

		graph = new LinkedList[n];
		vis = new boolean[n];
		cc = 0;

		for (int i=0; i<n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		while (m --> 0) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;

			graph[u].add(v);
			graph[v].add(u);
		}

		for (int u=0; u<n; u++) {
			if (!vis[u]) {
				cc ++;
				dfs(u);
			}
		}

		out.println(((long) pow(2, n - cc)));
	}

	public void dfs(int u) {
		vis[u] = true;

		for (int v : graph[u]) {
			if(!vis[v]) {
				dfs(v);
			}
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
