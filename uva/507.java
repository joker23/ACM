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

		int ttt = in.nextInt();

		for(int test = 1; test<=ttt; test++) {
			int n = in.nextInt() - 1;
			int[] arr = new int[n];

			for(int i=0; i<n; i++) {
				arr[i] = in.nextInt();
			}

			//start kadanes
			int gmax = arr[0];
			int tmax = arr[0];

			int s = 0;
			int ts = 0;
			int t = 0;

			for(int i=1; i<n; i++) {
				if(tmax < 0) {
					tmax = arr[i];
					ts = i;
				} else {
					tmax += arr[i];
				}

				if(gmax < tmax) {
					gmax = tmax;
					s = ts;
					t = i;
				} else if(gmax == tmax && ts == s) {
					t = i;
				}
			}

			if (gmax > 0) {
				s ++;
				t += 2;
				out.println("The nicest part of route " + test + " is between stops "+ s + " and " + t);
			} else {
				out.println("Route " + test + " has no nice parts");
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
