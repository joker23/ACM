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

	public void solve() throws Exception {
		st = new StringTokenizer(in.readLine());
		int n = parseInt(st.nextToken());
		int k = parseInt(st.nextToken());

		if(n == 1) {
			out.println(0);
			return;
		}
		st = new StringTokenizer(in.readLine());
		int[] arr = new int[n];

		for(int i=0; i< n; i++){
			arr[i] = parseInt(st.nextToken());
		}

		int besti = 0;
		int best = Integer.MAX_VALUE;
		for(int i=1; i<1001; i++) {
			int temp = 0;
			for(int j=0; j< arr.length; j++){
				if(i + (j*k) != arr[j]){
					temp ++;
				}
			}

			if(temp < best ) {
				best = temp;
				besti = i;
			}
		}

		out.println(best);

		for(int i=0; i<arr.length; i++){
			int target = besti + (i*k);
			if(arr[i] < target) {
				out.println("+ " + (i + 1) + " " + (target - arr[i]));
			}
			if(arr[i] > target) {
				out.println("- " + (i + 1) + " " + (arr[i] - target));
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
