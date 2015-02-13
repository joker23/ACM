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

	public void solve() throws Exception {
		int n = in.nextInt();
		int m = in.nextInt();

		char[][] board = new char[n][m];
		for (int i = 0; i<n; i++) {
			board[i] = in.next().toCharArray();
		}

		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				boolean ti = i % 2 == 0;
				boolean tj = j % 2 == 0;
				if (board[i][j] == '-') {
					out.print("-");
				} else if (ti ^ tj) {
					out.print("W");
				} else {
					out.print("B");
				}
			}

			out.println();
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
