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
		char[] arr = in.readLine().trim().toCharArray();
		char[] nextState = new char[n];
		while(true) {
			Arrays.fill(nextState, '.');
			boolean change = false;
			for(int i=0; i<n; i++){
				if(arr[i] != '.') {
					nextState[i] = arr[i];
				} else {
					if(i - 1 >= 0 && arr[i-1] == 'R') {
						nextState[i] = 'R';
					}

					if(i +1 <  n && arr[i+1] == 'L') {
						if(nextState[i] == '.'){
							nextState[i] = 'L';
						} else {
							nextState[i] = '.';
						}
					}
				}
			}
			for(int i=0; i<n; i++){
				if(arr[i] != nextState[i]){
					change = true;
				}
				arr[i] = nextState[i];
			}
			if(!change) {
				break;
			}
		}
		int ans = 0;
		for(int i=0; i< n; i++){
			if(arr[i] == '.'){
				ans ++;
			}
		}

		out.println(ans);
	}

	private void print(char[] arr){
		for(char c : arr) {
			System.out.print(c);
		}System.out.println();
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
