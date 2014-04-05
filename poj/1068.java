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

			int[] open = new int[n];

			for(int i=0; i<n; i++) {
				open[i] = in.nextInt();
			}

			int[] close = new int[n];

			close[0] = open[0];
			for(int i=1;i<n; i++){
				close[i] = open[i] - open[i-1];
			}

			int[] w = new int[n];
			for(int i=0; i<n; i++) {
				int val = 1;
				int l = 0;

				for(int j = i; j>=0; j--) {
					l += close[j];
					if(l >= val) {
						break;
					}
					val ++;
				}

				w[i] = val;
			}

			out.print(w[0]);

			for(int i=1; i<n; i++){
				out.print(" " + w[i]);
			}out.println();

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
