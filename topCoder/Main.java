import java.util.*;
import java.math.*;
<<<<<<< HEAD
import java.text.*;
import java.io.*;
=======
import java.io.*;
import java.text.*;
>>>>>>> ac7117327942436241cdb24d832c28891e8ad911
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

<<<<<<< HEAD
	// IO Imports
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int[] arr = new int[4];

		for(int i=0; i<4; i++) {
			String str[] = in.readLine().split("[.]");
			arr[i] = str[1].length();
		}

		int least = Integer.MAX_VALUE;
		for(int i : arr) {
			least = min(least, i);
		}

		int most = 0;
		for(int i : arr) {
			least = max(most, i);
		}

		boolean[] gcl = new boolean[4];
		boolean[] gcg = new boolean[4];

		for(int i=0; i<4; i++) {
			boolean g1 = true;
			boolean g2 = true;
			for(int j=0; j<4; j++) {
				if(j != i) {
					if(arr[i]/2 < arr[j]) {
						g2 = false;
					}
					if(arr[i]*2 > arr[j]) {
						g1 = false;
					}
				}
			}

			gcl[i] = g1;
			gcg[i] = g2;
		}

		int countg1 = 0;
		int countg2 = 0;

		for(int i=0; i<4; i++) {
			if(gcl[i]) {
				countg1 ++;
			}

			if(gcg[i]) {
				countg2++;
			}
		}

		if(countg1 == 1 || countg2== 1) {

			if(countg1 == 1) {
				int i;
				for(i=0; i<4; i++) {
					if(gcl[i]) {
						break;
					}
				}

				out.println((char)('A' + i));
			}else {

				int i;
				for(i=0; i<4; i++ ){
					if(gcg[i]) {
						break;
					}
				}

				out.println((char) ('A' + i));
			}
		}else {
			out.println("C");
=======
	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");


	public void solve() throws Exception {
		long[] dp = new long[101];

		dp[1] = 1;
		for(int i=2; i<=100; i++) {
			dp[i] = i* i + dp[i-1];
		}

		int n;

		while((n = in.nextInt()) > 0) {
			out.println(dp[n]);
>>>>>>> ac7117327942436241cdb24d832c28891e8ad911
		}
	}

	public Main() {
<<<<<<< HEAD
		this.in = new BufferedReader(new InputStreamReader(System.in));
=======
		this.in = new Scanner(System.in);
>>>>>>> ac7117327942436241cdb24d832c28891e8ad911
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
