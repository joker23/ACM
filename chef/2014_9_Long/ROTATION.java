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

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		st = new StringTokenizer(in.readLine());
		int n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());

		int arr[] = new int[n];

		st = new StringTokenizer(in.readLine());
		for (int i=0; i<n; i++) {
			arr[i] = parseInt(st.nextToken());
		}

		int ptr = 0;

		while (m --> 0) {
			st = new StringTokenizer(in.readLine());
			char query = st.nextToken().toCharArray()[0];
			int num = parseInt(st.nextToken());

			switch (query) {
				case 'C' :
					ptr = (ptr + num) % n;
					break;
				case 'R' :
					out.println(arr[(ptr + num - 1) % n]);
					break;
				case 'A' :
					ptr = ((ptr - num) + n) % n;
			}
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
