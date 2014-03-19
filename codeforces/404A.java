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

	public void solve() throws Exception {
		int n = parseInt(in.readLine().trim());

		char[][] board = new char[n][n];
		for(int i=0; i<n; i++){
			String str = in.readLine().trim();
			for(int j=0; j<n; j++){
				board[i][j] = str.charAt(j);
			}
		}
		char a = board[0][0];
		char b = board[0][1];

		if(a == b){
			out.println("NO");
			return;
		}

		for(int i=0;i<n; i++){
			for(int j=0; j<n; j++){
				if(i == j || i == n - 1 -j) {
					if(board[i][j] != a) {
						out.println("NO");
						return;
					}
				} else {
					if(board[i][j] != b){
						out.println("NO");
						return;
					}
				}
			}
		}

		out.println("YES");
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
