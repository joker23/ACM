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

	LinkedList<Integer>[] tree;
	int[][] memo;

	public void solve() throws Exception {
		int n = parseInt(in.readLine().trim());
		tree = new LinkedList[n + 1];
		for(int i=0; i<=n; i++){
			tree[i] = new LinkedList<Integer>();
		}

		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(in.readLine());

			int u = parseInt(st.nextToken());
			int v = parseInt(st.nextToken());

			tree[u].add(v);
			tree[v].add(u);
		}

		memo = new int[n + 1][2];

		for(int i=0; i<memo.length; i++) {
			fill(memo[i], -1);
		}

		out.println(dfs(1, -1 ,1));

	}

	public int dfs(int curr, int prev, int flag) {
		if(memo[curr][flag] != -1) {
			return memo[curr][flag];
		}

		int x = 1, y = 0;
		for(int next : tree[curr]) {
			if(next == prev) continue; //leaf
			x += dfs(next, curr, 1);
			y += dfs(next, curr, 0);
		}

		return memo[curr][flag] = (flag == 1 ? min(x, y) : x);
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
