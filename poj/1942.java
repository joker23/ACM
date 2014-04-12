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

	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	public void solve() throws Exception {
		while(true) {
			st = new StringTokenizer(in.readLine());
			long n = parseLong(st.nextToken());
			long m = parseLong(st.nextToken());
			if(n + m == 0) {
				break;
			}

			out.println(r(n + m, min(n,m)));
		}
	}

	public long r(long a, long b) {
		if(b == 0) {
			return 1;
		} else if (b == 1) {
			return a;
		} else {
			return r(a-1, b-1) * a/b;
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
