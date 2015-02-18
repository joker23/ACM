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
		out.println(bruteForce());
	}

	private long bruteForce() {
		int n = in.nextInt();
		int m = in.nextInt();

		long ans = 0;

		for (int i=0; i<n; i++) {
			ans += f(in.nextInt());
			ans %= m;
		}

		return ans;
	}

	private long f(int x) {
		long ans = 0;

		for (int i = 1; i <=x ; i++) {
			ans += i * (factorial(i) + x);
		}

		return ans;
	}

	private long factorial(int n) {
		long ans = 1;

		for (int i = 1; i <= n; i++) {
			ans *= i;
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
