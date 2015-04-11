
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

public class B {

	// IO Imports
	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int n = in.nextInt();
		
		int[] arr1 = new int[n];
		int[] arr2 = new int[n-1];
		int[] arr3 = new int[n-2];
		
		for (int i=0; i<n; i++) {
			arr1[i] = in.nextInt();
		}
		
		for (int i=0; i<n-1; i++) {
			arr2[i] = in.nextInt();
		}
		
		for (int i=0;i<n-2; i++) {
			arr3[i] = in.nextInt();
		}

		sort(arr1);
		sort(arr2);
		sort(arr3);
		
		int ans = arr1[n-1];
		
		for (int i=0; i<n-1; i++) {
			if (arr1[i] != arr2[i]) {
				ans = arr1[i];
				break;
			}
		}
		
		out.println(ans);
		
		ans = arr2[n-2];
		
		for (int i=0;i<n-2; i++) {
			if (arr2[i] != arr3[i]) {
				ans = arr2[i];
				break;
			}
		}
		
		out.println(ans);
	}

	public B() {
		this.in = new Scanner(System.in);
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
		B solver = new B();
		solver.solve();
		solver.end();
	}
}

