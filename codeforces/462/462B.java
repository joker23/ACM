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

		char[][] arr = new char[n][n];
		char[] line;
		for(int i=0; i<n; i++) {
			line = in.next().trim().toCharArray();
			for(int j=0; j<n; j++) {
				arr[i][j] = line[j];
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int count = 0;
				if (i > 0) {
					count += arr[i-1][j] == 'o' ? 1 : 0;
				}

				if (i < n - 1) {
					count += arr[i + 1][j] == 'o' ? 1 : 0;
				}

				if (j > 0) {
					count += arr[i][j -1] == 'o' ? 1 : 0;
				}

				if (j < n -1) {
					count += arr[i][j + 1] == 'o' ? 1 : 0;
				}

				if (count % 2 != 0) {
					out.println("NO");
					return;
				}
			}
		}

		out.println("YES");
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
