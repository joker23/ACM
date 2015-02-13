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
		int n = parseInt(in.readLine().trim());

		int[] arr = new int[n];
		int[] num = new int[n];

		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			num[i] = parseInt(st.nextToken());
			arr[i] = 15 * num[i];
		}

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<num[i]; j++) {
				arr[i] += 5 * parseInt(st.nextToken());
			}
		}

		int ans = Integer.MAX_VALUE;

		for(int i=0; i<n; i++){
			ans = min(ans, arr[i]);
		}

		out.println(ans);
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
