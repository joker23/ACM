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

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	public void solve() throws Exception {
		int t = in.nextInt();

		while(t --> 0) {
			int n = in.nextInt();
			int e = in.nextInt();
			int time = in.nextInt();

			n++;
			long[][] graph = new long[n][n];

			for(int i=0; i<n; i++) {
				fill(graph[i], time + 1);
			}

			int m = in.nextInt();

			while(m --> 0) {
				graph[in.nextInt()][in.nextInt()] = in.nextInt();
			}

			for(int k = 0; k<n; k++) {
				for(int i =0; i<n; i++) {
					for(int j=0; j<n; j++) {
						graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}

			int ans=0;

			for(int i=0; i< n; i++) {
				if(graph[i][e] <= time || i == e) {
					ans ++;
				}
			}

			out.println(ans);
			if(t > 0) {
				out.println();
			}
		}
	}

	public Main() {
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
		Main solver = new Main();
		solver.solve();
		solver.end();
	}
}
