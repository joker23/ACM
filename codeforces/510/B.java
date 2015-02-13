package r290B;

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

	// IO Imports
	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	private boolean[][] vis;
	private char[][] b;
	public void solve() throws Exception {
		int n = in.nextInt();
		int m = in.nextInt();
		
		b = new char[n][m];
		vis = new boolean[n][m];
		
		for (int i=0; i<n; i++) {
			char[] tmp = in.next().trim().toCharArray();
			for (int j=0; j<m; j++) {
				b[i][j] = tmp[j];
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (!vis[i][j]) {
					vis[i][j] = true;
					if (dfs(i, j, b[i][j], -1)) {
						out.println("Yes");
						return;
					}
				}
			}
		}
		
		out.println("No");
	}
	
	private int[] di = {1, -1, 0, 0};
	private int[] dj = {0, 0, -1, 1};
	
	private boolean dfs(int i, int j, char curr, int prev) {
		boolean ans = false;
		
		for (int a=0; a<di.length; a++)  {
			int ni = i + di[a];
			int nj = j + dj[a];
			
			if (a == prev || ni < 0 || ni >= b.length || nj < 0 || nj >= b[ni].length || b[ni][nj] != curr) {
				continue;
			}
			
			if (vis[ni][nj]) {
				return true;
			} else {
				vis[ni][nj] = true;
				int tmp = -1;
				if (a == 0) tmp = 1;
				if (a == 1) tmp = 0;
				if (a == 2) tmp = 3;
				if (a == 3) tmp = 2;
				ans = ans | dfs(ni, nj, curr, tmp);
			}
		}
		
		return ans;
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
		} catch (Exception e) {
			//do nothing then :)
		}
	}

	public static void main(String[] args) throws Exception {
		B solver = new B();
		solver.solve();
		solver.end();
	}
}

