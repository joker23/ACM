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
		int[] arr = new int[n];
		char[] carr = in.next().toCharArray();

		for (int i=0; i<n; i++) {
			arr[i] = carr[i] - '0';
		}

		String ans = stringify(arr, n, 0);

		for (int i = 1; i<n; i++) {
			String tmp = stringify(arr, n, i);

			if (tmp.compareTo(ans) < 0) {
				ans = tmp;
			}
		}

		out.println(ans);
	}

	public String stringify(int[] arr, int n, int s) {
		int diff = 10 - arr[s];

		StringBuilder sb = new StringBuilder();
		for (int i=s; i<n + s; i++) {
			int index = i % n;
			sb.append((arr[index] + diff) % 10);
		}

		return sb.toString();
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
