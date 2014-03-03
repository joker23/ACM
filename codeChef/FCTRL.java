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

		int t = parseInt(in.readLine().trim());
		while(t --> 0){
			int n = parseInt(in.readLine().trim());
			out.println(countZeroes(n));
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

	private long cat(int n){
		long[] cat = new long[n+1];
		cat[0] = 1;
		for(int i=1; i<cat.length; i++){
			for(int j=0; j<i; j++){
				cat[i] += cat[j] * cat[i-j-1];
			}
		} return cat[n];
	}

	private long countZeroes (long n) {
		int count = 0;
		while(n!=0) {
			count+=n/5;
			n/=5;
		}
		return count;
	}
}
