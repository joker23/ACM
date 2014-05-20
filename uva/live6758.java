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
		int test = in.nextInt();

		int n, x, y;
		while (test --> 0) {
			n = in.nextInt();
			x = in.nextInt();
			y = in.nextInt();

			int[] arr = new int[n];

			for(int i=0; i<n; i++) {
				arr[i] = in.nextInt();
			}

			boolean easy = arr[0] == x;
			boolean hard = arr[n-1] == y;

			if (easy && hard) {
				out.println("BOTH");
			} else if (easy) {
				out.println("EASY");
			} else if (hard) {
				out.println("HARD");
			} else {
				out.println("OKAY");
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
