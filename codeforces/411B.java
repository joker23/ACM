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
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		boolean[] isLocked = new boolean[1000];
		int[] whenLocked = new int[n];

		int[][] instructions = new int[n][m];

		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				instructions[i][j] = in.nextInt();
			}
		}

		int[] totalAccess = new int[1000];

		boolean[] vis = new boolean[1000];

		for (int j=0; j<m; j++) {
			for (int i=0; i<k+1; i++) {
				vis[i] = isLocked[i];
			}

			fill(totalAccess, 0);

			for(int i=0; i<n; i++) {
				if(whenLocked[i] == 0)
					totalAccess[instructions[i][j]] ++;
			}

			for (int i=0; i<n; i++) {
				if(whenLocked[i] > 0) {
					continue;
				}

				int cache = instructions[i][j];

				if(cache == 0) {
					continue;
				}

				if(totalAccess[cache] > 1 || isLocked[cache]) {
					whenLocked[i] = j + 1;
					isLocked[cache] = true;
				}
			}
		}

		for(int i=0; i<n; i++) {
			out.println(whenLocked[i]);
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
