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

		while(t --> 0) {
			int n = parseInt(in.readLine().trim());

			st = new StringTokenizer(in.readLine());
			int min = 200;
			int max = 0;
			for(int i=0; i<n; i++){
				int tmp = parseInt(st.nextToken());
				min = min(min, tmp);
				max = max(max, tmp);
			}
			out.println(((max - min) * 2));
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
