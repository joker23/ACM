import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;
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

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");


	int[][] h;
	public void solve() throws Exception {
		h = new int[5][5];

		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				h[i][j] = in.nextInt();
			}
		}

		out.println(dfs(""));
	}

	public int dfs(String state){
		if(state.length() == 5) {
			return calc(state);
		}

		int ans = 0;
		for(int i=0; i<5; i++) {
			if (!state.contains("" + i))
				ans = max(ans, dfs(state + i));
		} return ans;
	}

	public int calc(String in) {
		int[] arr = new int[5];

		for(int i=0; i<5; i++) {
			arr[i] = in.charAt(i) - '0';
		}

		int ans = 0;

		ans += h[arr[0]][arr[1]] + h[arr[1]][arr[0]] + h[arr[2]][arr[3]] + h[arr[3]][arr[2]];
		ans += h[arr[1]][arr[2]] + h[arr[2]][arr[1]] + h[arr[3]][arr[4]] + h[arr[4]][arr[3]];
		ans += h[arr[2]][arr[3]] + h[arr[3]][arr[2]];
		ans += h[arr[3]][arr[4]] + h[arr[4]][arr[3]];

		return ans;
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
