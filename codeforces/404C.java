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
	private ArrayList<Integer>[] dist;

	public void solve() throws Exception {
		st = new StringTokenizer(in.readLine());
		int n = parseInt(st.nextToken());
		int k = parseInt(st.nextToken());
		int arr[] = new int[n + 1];

		int m = 0;
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++){
			arr[i] = parseInt(st.nextToken());
			m = max(m, arr[i]);
		}

		dist = new ArrayList[m + 1];

		for(int i=0; i<=m; i++){
			dist[i] = new ArrayList<Integer>();
		}

		for(int i=1; i<=n; i++){
			dist[arr[i]].add(i);
		}

		if(dist[0].size() != 1){
			out.println(-1);
			return;
		}

		if(dist[1].size() > k) {
			out.println(-1);
			return;
		}

		for(int i=2; i<=m; i++){
			long comp = ((long) dist[i-1].size()) * (k-1);
			if(dist[i].size() > comp) {
				out.println(-1);
				return;
			}
		}

		int num = 0;
		for(int i=1; i<=m; i++){
			num += dist[i].size();
		}

		out.println(num);
		for(int i : dist[1]) {
			out.println(dist[0].get(0) + " " + i);
		}

		for(int i=2; i<=m; i++){
			for(int j=0; j < dist[i].size(); j++){
				out.println(dist[i-1].get(j/(k - 1)) + " " + dist[i].get(j));
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
