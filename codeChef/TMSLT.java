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
	//use count sort... interesting

	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	public void solve() throws Exception {
		int t = parseInt(in.readLine().trim());
		int[] cnt = new int[1000001];

		while (t --> 0) {
			st = new StringTokenizer(in.readLine());
			int n = parseInt(st.nextToken());
			long a = parseLong(st.nextToken());
			long b = parseLong(st.nextToken());
			long c = parseLong(st.nextToken());
			long d = parseLong(st.nextToken());

			fill(cnt, 0);

			long s = d;
			cnt[(int)s] ++;
			for(int i=0; i<n - 1; i++){
				cnt[(int)(s = (a * s * s + b * s + c) % 1000000)]++;
			}

			int index = 0;
			int ans = 0;

			for(int i=0; i<cnt.length; i++){
				if(index%2 == 0) ans += (cnt[i] % 2) * i;
				else ans -= (cnt[i] % 2) * i;

				index += cnt[i];
			}

			out.println(abs(ans));
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
