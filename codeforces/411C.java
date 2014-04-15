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
		int[] p1att = new int[2];
		int[] p1def = new int[2];

		int[] p2att = new int[2];
		int[] p2def = new int[2];

		for(int i=0; i<2; i++) {
			p1att[i] = in.nextInt();
			p1def[i] = in.nextInt();
		}

		for(int i=0; i<2; i++) {
			p2att[i] = in.nextInt();
			p2def[i] = in.nextInt();
		}

		int[][] lookup = new int[2][2];

		lookup[0][0] = point(p1att[0], p1def[1], p2att[0], p2def[1]);
		lookup[1][0] = point(p1att[1], p1def[0], p2att[0], p2def[1]);
		lookup[0][1] = point(p1att[0], p1def[1], p2att[1], p2def[0]);
		lookup[1][1] = point(p1att[1], p1def[0], p2att[1], p2def[0]);

		//choose column
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<2; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0; j<2; j++) {
				min = min(min, lookup[i][j]);
			}
			ans = max(ans, min);
		}

		if(ans == 0){
			out.println("Draw");
		} else if(ans > 0) {
			out.println("Team 1");
		} else {
			out.println("Team 2");
		}
	}

	private int point(int p1att, int p1def, int p2att, int p2def) {
		int ans = 0;
		if(p1att > p2def && p1def > p2att) {
			ans ++;
		}

		if(p2att > p1def && p2def > p1att) {
			ans --;
		}

		return ans;
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
