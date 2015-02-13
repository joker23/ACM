package r507B;
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

public class A {

	// IO Imports
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		List<Integer> ans = new ArrayList<Integer>();
		int used = 0;
		boolean[] vis = new boolean[n];
		while (true) {
			int tmp = Integer.MAX_VALUE;
			int ind = -1;
			
			for (int i=0; i<n; i++) {
				if (tmp > arr[i] && !vis[i] && k - arr[i] >= 0) {
					ind = i;
					tmp = arr[i];
				}
			}
			
			if (ind == -1) {
				break;
			}
			
			vis[ind] = true;
			used ++;
			k -= tmp;
			ans.add(ind + 1);			
		}
		
		out.println(ans.size());
		
		while(!ans.isEmpty()) {
			out.print(ans.remove(0));
			if (!ans.isEmpty()) {
				out.print(" ");
			}
		}
	}

	public A() {
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = new PrintWriter(System.out);
	}

	public void end() {
		try {
			this.out.flush();
			this.out.close();
			this.in.close();
		} catch (Exception e) {
			//do nothing then :)
		}
	}

	public static void main(String[] args) throws Exception {
		A solver = new A();
		solver.solve();
		solver.end();
	}
}

