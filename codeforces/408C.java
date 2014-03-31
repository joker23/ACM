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
		char[] str1 = in.readLine().trim().toCharArray();
		char[] str2 = in.readLine().trim().toCharArray();

		int[] count1 = new int[Character.MAX_VALUE];
		int[] count2 = new int[Character.MAX_VALUE];

		for(int i=0; i<str1.length; i++){
			count1[str1[i]] ++;
		}

		for(int i=0; i<str2.length; i++){
			count2[str2[i]] ++;
		}

		int ans = 0;
		for(int i = 'a'; i<='z'; i++){
			int have = count1[i];
			int need = count2[i];

			if(have >= need) {
				ans += need;
			} else {
				if(have == 0) {
					out.println(-1);
					return;
				}
				ans += have;
			}
		}

		out.println(ans == 0 ? -1 : ans);
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
