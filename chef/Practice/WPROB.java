import java.util.*;
import java.math.*;
import java.text.*;
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

	// IO Imports
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	private static char[][] sorts;

	static {
		sorts = new char[6][3];

		sorts[0] = new char[] {'r', 'g', 'b'};
		sorts[1] = new char[] {'r' ,'b' ,'g'};
		sorts[2] = new char[] {'b', 'r', 'g'};
		sorts[3] = new char[] {'b', 'g', 'r'};
		sorts[4] = new char[] {'g', 'r', 'b'};
		sorts[5] = new char[] {'g', 'b', 'r'};
	}

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int t = Integer.parseInt(in.readLine());

		while (t --> 0) {
			char[] arr = in.readLine().toCharArray();

			int ans = -1;

			for (int i=0; i<sorts.length; i++) {
				int candidate = 0;
				int seen[] = new int[3];
				for (int j=0; j<arr.length; j++) {
					if (arr[j] == sorts[i][0]) {
						seen[0] ++;
						candidate += seen[1] + seen[2];
					} else if (arr[j] == sorts[i][1]) {
						candidate += seen[2];
						seen[1] ++;
					} else {
						seen[2] ++;
					}
				}
				if (ans == -1) {
					ans = candidate;
				} else {
					ans = Math.min(ans, candidate);
				}
			}

			out.println(ans);
		}
	}

	public Main() {
		this.in = new BufferedReader(new InputStreamReader(System.in));
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
