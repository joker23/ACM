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

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;
	private int memo[];

	public void solve() throws Exception {

		memo = new int[1000001];
		while(in.hasNextInt()) {
			int a = in.nextInt();
			int b = in.nextInt();
			int ans = 0;

			for(int i=min(a, b); i<=max(a,b); i++) {
				ans = max(ans, runProblem(i));
			}

			out.println(a + " " + b + " " + ans);
		}
	}

	public int runProblem(int n) {
		long tmp = n;
		int ans = 1;

		while(tmp != 1) {
			if(tmp < memo.length && memo[(int)tmp] > 0){
				return ans + memo[(int)tmp] - 1;
			}

			if((tmp & 1) == 0) {
				tmp /= 2;
			} else {
				tmp = (tmp * 3) + 1;
			}
			ans ++;
		}

		memo[n] = ans;

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
