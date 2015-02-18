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

public class A {

	// IO Imports
	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		boolean[][] board = new boolean[n][m];

		int turn = 0;

		while (k-- > 0) {
			turn++;
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;

			board[x][y] = true;

			// checks
			if (x > 0) {
				if (y > 0) {
					if (board[x - 1][y] && board[x - 1][y - 1]
							&& board[x][y - 1]) {
						out.println(turn);
						return;
					}
				}

				if (y > m - 1) {

					if (board[x - 1][y] && board[x - 1][y + 1]
							&& board[x][y + 1]) {
						out.println(turn);
						return;
					}
				}
			}

			if (x < n - 1) {
				if (y > 0) {
					if (board[x + 1][y] && board[x + 1][y - 1]
							&& board[x][y - 1]) {
						out.println(turn);
						return;
					}
				}

				if (y < m - 1) {
					if (board[x + 1][y] && board[x + 1][y + 1]
							&& board[x][y + 1]) {
						out.println(turn);
						return;
					}
				}
			}
		}

		out.println(0);
	}

	public A() {
		this.in = new Scanner(System.in);
		this.out = new PrintWriter(System.out);
	}

	public void end() {
		try {
			this.out.flush();
			this.out.close();
			this.in.close();
		} catch (Exception e) {
			// do nothing then :)
		}
	}

	public static void main(String[] args) throws Exception {
		A solver = new A();
		solver.solve();
		solver.end();
	}
}
