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

public class C {

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	private boolean[][] cracked;
	private char[][] graph;
	private int[] dx = new int[] {1, -1, 0, 0};
	private int[] dy = new int[] {0, 0, -1, 1};
	private int gx;
	private int gy;
	private int sx;
	private int sy;
	private int n;
	private int m;

	public void solve() throws Exception {
		n = in.nextInt();
		m = in.nextInt();

		graph = new char[n][m];
		cracked = new boolean[n][m];

		for (int i=0; i<n; i++) {
			graph[i] = in.next().trim().toCharArray();
		}
		sx = in.nextInt() - 1;
		sy = in.nextInt() - 1;

		gx = in.nextInt() - 1;
		gy = in.nextInt() - 1;

		cracked[sx][sy] = true;

		if (sx == gx && sy == gy) {
			if (graph[sx][sy] == 'X') {

			}
		}

		int scount = 0;
		for (int i=0; i<4; i++) {
			int nx = sx + dx[i];
			int ny = sy + dy[i];
			if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) {
				continue;
			}

			if (graph[nx][ny] == '.') {
				scount ++;
			}
		}


		int gcount = 0;
		for (int i=0; i<4; i++) {
			int nx = gx + dx[i];
			int ny = gy + dy[i];
			if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) {
				continue;
			}

			if (graph[nx][ny] == '.') {
				gcount++;
			}
		}

		boolean isNeighbors = false;

		for (int i=0; i<4 && !isNeighbors; i++) {
			int nx = sx + dx[i];
			int ny = sy + dy[i];
			if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) {
				continue;
			}
			if (nx == gx && ny == gy) {
				isNeighbors = true;
			}
		}

		if (sx == gx && sy == gy) {
			if (graph[sx][sy] == 'X') {
				if (scount >= 1) {
					out.println("YES");
				} else {
					out.println("NO");
				}
			} else {
				if (scount >= 2) {
					out.println("YES");
				} else {
					out.println("NO");
				}
			}
		} else if (isNeighbors) {
			if (graph[gx][gy] == 'X') {
				out.println("YES");
			} else {
				if (gcount >= 1) {
					out.println("YES");
				} else {
					out.println("NO");
				}
			}
		} else if (dfs(sx, sy)) {
			if (graph[gx][gy] == 'X') {
				out.println("YES");
			} else {
				if (gcount >= 2) {
					out.println("YES");
				} else {
					out.println("NO");
				}
			}
		} else {
			out.println("NO");
		}
	}

	private boolean dfs(int x, int y) {
		boolean ret = false;

		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) {
				continue;
			}

			if (nx == gx && ny == gy) {
				return true;
			} else {
				if (!cracked[nx][ny] && graph[nx][ny] != 'X') {
					cracked[nx][ny] = true;
					ret |= dfs(nx, ny);
				}
			}
		}

		return ret;
	}

	public C() {
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
		C solver = new C();
		solver.solve();
		solver.end();
	}
}
