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
	private int t,n, w[];
	private long twos[], ones[], zeros[];
	public void solve() throws Exception {
		t = parseInt(in.readLine().trim());
		while(t --> 0) {
			n = parseInt(in.readLine().trim());

			w = new int[n];
			st = new StringTokenizer(in.readLine().trim());
			long res = 0;

			for(int i=0; i<n; i++){
				w[i] = parseInt(st.nextToken().trim());
				res += i;
			}
			twos = new long[n];
			ones = new long[n];
			zeros = new long[n];

			for(int i=n-2; i>=0; i--) {
				twos[i] = twos[i+1] + (w[i+1] == 2 ? 1 : 0);
				zeros[i] = zeros[i+1] + (w[i+1] == 0 ? 1 : 0);
				ones[i] = ones[i+1] + (w[i+1] == 1 ? 1 : 0);
			}

			for(int i=0; i<n; i++){
				if(w[i] < 2) {
					res -= n -i - 1;
				} else if(w[i] == 2) {
					res -= twos[i];
					res -= ones[i] + zeros[i];
				}
				else {
					res -= ones[i] + zeros[i];
				}

			}
			//System.out.println(res);
			out.println(res);
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
