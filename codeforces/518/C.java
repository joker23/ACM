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
		int k = in.nextInt();

		int[] arr = new int[n];

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i=0; i<n; i++) {
			int app = in.nextInt();
			map.put(app, i);
			arr[i] = app;
		}

		long ans = 0;

		for (int i=0; i<m; i++) {
			int app = in.nextInt();
			int appIndex = map.get(app);
			int tmp = appIndex/k + 1;

			if (appIndex > 0) {
				int prevApp = arr[appIndex - 1];
				arr[appIndex - 1] = app;
				arr[appIndex] = prevApp;

				map.put(app, map.remove(app) - 1);
				map.put(prevApp, map.remove(prevApp) + 1);
			}

			ans += tmp;
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
