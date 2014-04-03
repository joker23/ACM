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

	private int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
	private int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
	private int n;
	private boolean[][] board;
	public void solve() throws Exception {
		String str;
		int test = 0;

		while((str = in.readLine()) != null) {
			test ++;
			n = parseInt(str);
			board = new boolean[n][n];
			for(int i=0; i<n; i++) {
				String tmp = in.readLine().trim();
				for(int j=0; j<n; j++) {
					board[i][j] = tmp.charAt(j) == '1';
				}
			}

			int ans = 0;
			for(int i = 0 ; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(board[i][j]) {
						ans ++;
						dfs(i,j);
					}
				}
			}

			out.println("Image number " + test + " contains " + ans + " war eagles.");
		}
	}

	public void dfs (int x, int y) {
		if(x<0 || x >= n || y< 0|| y>= n || !board[x][y]) {
			return;
		}

		board[x][y] = false;

		for(int i=0; i<dx.length; i++) {
			dfs(x + dx[i], y + dy[i]);
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
