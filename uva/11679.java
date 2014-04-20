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
			int b = parseInt(st.nextToken());
			int n = parseInt(st.nextToken());

			if(b + n == 0) {
				break;
			}

			int[] has = new int[b + 1];
			st = new StringTokenizer(in.readLine());
			for(int i=1; i<=b; i++) {
				has[i] = parseInt(st.nextToken());
			}

			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				int u = parseInt(st.nextToken());
				int v = parseInt(st.nextToken());
				int w = parseInt(st.nextToken());

				has[v] += w;
				has[u] -= w;
			}

			boolean ans = true;
			for(int i=1; i<=b; i++) {
				ans &= has[i] >= 0;
				if(!ans) break;
			}

			if(ans) out.println('S');
			else out.println('N');
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
