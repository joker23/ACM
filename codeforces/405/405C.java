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
		int n = parseInt(in.readLine().trim());
		boolean arr[][] = new boolean[n][n];
		boolean ans[] = new boolean[n];
		int count = 0;

		for(int i=0; i<n; i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++){
				arr[i][j] = parseInt(st.nextToken()) == 1 ? true : false;
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				ans[i] ^= arr[i][j] & arr[j][i];
			}
			if(ans[i]){
				count ++;
			}
		}


		int m = parseInt(in.readLine().trim());

		while(m --> 0) {
			st = new StringTokenizer(in.readLine());
			int command = parseInt(st.nextToken());

			if(command == 3) {
				boolean b = false;
				for(int i=0; i<n; i++){
					b ^= ans[i];
				}

				out.print(b ? 1 : 0);
			}

			else {
				int index = parseInt(st.nextToken()) - 1;
				if(ans[index]) {
					count --;
				} else {
					count ++;
				}

				ans[index] = !ans[index];
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
