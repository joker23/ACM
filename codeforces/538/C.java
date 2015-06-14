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

public class C {

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int n = in.nextInt();
		int m = in.nextInt();

		int ans = 0;

		int d[] = new int[m];
		int h[] = new int[m];

		for (int i=0; i<m; i++) {
			d[i] = in.nextInt();
			h[i] = in.nextInt();

			if (h[i] > ans) {
				ans = h[i];
			}
		}

		for(int i=1; i<m; i++) {
			if (d[i] - d[i-1] < abs(h[i] - h[i-1])) {
				out.println("IMPOSSIBLE");
				return;
			}

			for (int j=d[i-1]; j<=d[i]; j++) {
				int tmp = min(h[i-1] + j - d[i-1], h[i] + d[i] - j);
				if (tmp > ans) {
					ans = tmp;
				}
			}
		}

		int tmp = max(h[m - 1] + n - d[m - 1], h[0] + d[0] - 1);
		if (tmp > ans) {
			ans = tmp;
		}

		out.println(ans);
	}

	public C() {
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
		C solver = new C();
		solver.solve();
		solver.end();
	}
}
