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

	private int n;
	private int[] arr;

	public void solve() throws Exception {
		n = parseInt(in.readLine().trim());
		arr = new int[n];

		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++){
			arr[i] = parseInt(st.nextToken());
		}

		sort(arr);

		int ans = 100;
		for(int i=1; i<n+1; i++){
			boolean canSolve = true;
			for(int j=0; j<n; j++){
				if(arr[j] < j / i) {
					canSolve = false;
					break;
				}
			}

			if(canSolve) {
				out.println(i);
				break;
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
