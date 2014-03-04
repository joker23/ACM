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

	int n,p,k, arr[];
	boolean f,l;

	public void solve() throws Exception {
		st = new StringTokenizer(in.readLine());
		n = parseInt(st.nextToken());
		p = parseInt(st.nextToken());
		k = parseInt(st.nextToken());
		arr = new int[1+(2*k)];
		f = l = true;

		arr[arr.length/2] = p;
		for(int i=1; i<=k; i++){
			arr[(arr.length/2) + i] = arr[(arr.length/2) + i - 1] + 1;
			arr[(arr.length/2) - i] = arr[(arr.length/2) - i + 1] - 1;
		}

		if(arr[0] <= 1) {
			f = false;
		}

		if(arr[arr.length - 1] >= n) {
			l = false;
		}
		String res = "";
		if (f) {
			res += "<< ";
		}

		for(int i=0; i<arr.length; i++){
			if(arr[i] == arr[arr.length/2]) {
				res += "("+arr[i]+") ";
			}
			else if(arr[i]>=1 && arr[i]<=n){
				res += arr[i] + " ";
			}
		}

		if (l) {
			res += ">>";
		}

		out.println(res.trim());
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
