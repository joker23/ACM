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
		int tt = in.nextInt();

		while (tt --> 0) {
			int n = in.nextInt();
			int p = 0;

			int[] dx = new int[n + 1];
			for (int i=1; i<=n; i++) {
				String command = in.next().trim();

				if (command.equals("LEFT")) {
					dx[i] = -1;
				} else if (command.equals("RIGHT")) {
					dx[i] = 1;
				} else {
					in.next();
					dx[i] = dx[in.nextInt()];
				}
			}

			for (int i : dx) {
				p += i;
			}

			out.println(p);
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
