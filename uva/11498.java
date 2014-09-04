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

		while (tt != 0) {
			int x = in.nextInt();
			int y = in.nextInt();
			while (tt --> 0) {
				int tmpx = in.nextInt();
				int tmpy = in.nextInt();

				if (tmpx == x || tmpy == y) {
					out.println("divisa");
				} else {
					if (tmpy > y) {
						out.print("N");
					} else {
						out.print("S");
					}

					if (tmpx > x) {
						out.println("E");
					} else {
						out.println("O");
					}
				}
			}
			tt = in.nextInt();
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
