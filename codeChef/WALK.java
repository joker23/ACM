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
	private int t, n, arr[];

	public void solve() throws Exception {
		t = parseInt(in.readLine().trim());
		while(t --> 0){
			n = parseInt(in.readLine().trim());
			arr = new int[n];
			st = new StringTokenizer(in.readLine());
			int res = 0;
			for(int i=0; i<n; i++){
				arr[i] = parseInt(st.nextToken());
				res = max(res, arr[i] + i);
			}
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
