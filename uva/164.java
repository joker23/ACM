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
/**
 * uva 164
 */
public class Main {

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private int[][] dp;
	private int[][] prevr, prevc;
	private int n,m;
	public void solve() throws Exception {
		String line, input, target;

		while(!(line = in.nextLine()).trim().equals("#")) {
			String[] sp = line.split(" ");
			if(sp.length == 1) {
				if(line.charAt(0) == ' ') {
					input = "";
					target = sp[1];
				} else {
					input = sp[0];
					target ="";
				}
			} else {
				input = sp[0];
				target = sp[1];
			}
			n = input.length();
			m = target.length();

			dp = new int[n + 1][m + 1];
			prevr = new int[n+1][m+1];
			prevc = new int[n+1][m+1];

			for(int i=1; i<=n; i++) {
				dp[i][0] = i;
				prevr[i][0] = i - 1;
			}

			for(int i=1; i<=m; i++) {
				dp[0][i] = i;
				prevc[0][i] = i - 1;
			}

			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					if(input.charAt(i - 1) == target.charAt(j - 1)) {
						dp[i][j] = dp[i-1][j-1];
						prevr[i][j] = i-1;
						prevc[i][j] = j-1;
					} else {
						int min = dp[i-1][j];
						prevr[i][j] = i -1;
						prevc[i][j] = j;

						if(dp[i][j-1] < min) {
							min = dp[i][j-1];
							prevr[i][j] = i;
							prevc[i][j] = j-1;
						}

						if(dp[i-1][j-1] < min) {
							min = dp[i-1][j-1];
							prevr[i][j] = i - 1;
							prevc[i][j] = j - 1;
						}

						dp[i][j] = min + 1;
					}
				}
			}

			int ans = dp[n][m];

			char[] change = new char[ans];
			char[] letter = new char[ans];
			int[] index = new int[ans];

			ans --;

			int i = n;
			int j = m;
			String ret = "E";
			while(i + j > 0 && ans >= 0) {
				int pi = prevr[i][j];
				int pj = prevc[i][j];
				if(pi < 0 || pj < 0) {
					break;
				}

				if(dp[pi][pj] < dp[i][j]) {
					if(pi < i && pj < j) {
						//it is an change
						letter[ans] = target.charAt(j-1);
						change[ans] = 'C';
						index[ans] = i;

					} else if(pi < i) {
						//it is an insert

						change[ans] = 'D';
						letter[ans] = input.charAt(i-1);
						index[ans] = i;

					} else if(pj < j) {
						change[ans] = 'I';
						letter[ans] = target.charAt(j-1);
						index[ans] = i + 1;
					}

					ans --;
				}

				i = pi;
				j = pj;
			}

			for(i=0; i<change.length; i++) {
				out.print(Character.toString(change[i]) + Character.toString(letter[i])+ (index[i] < 10 ? "0" : "") + index[i]);

				if(change[i] == 'D') {
					for(j=i; j<change.length; j++) {
						index[j] --;
					}
				} else if(change[i] == 'I') {
					for(j=i; j<change.length; j++) {
						index[j] ++;
					}
				}
			}

			out.println("E");
		}
	}

	public void print(int i, int j) {
		if(i + j == 0) {
			return;
		}
	}

	public void print(int[][] dp) {
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				System.out.print("[" + dp[i][j] + "]");
			}System.out.println();
		}System.out.println();
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
