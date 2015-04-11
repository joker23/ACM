
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

public class D {

	// IO Imports
	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int[] map = new int[26];
		for (int i=0; i<26; i++) {
			map[i] = in.nextInt();
		}
		
		char[] str = in.next().toCharArray();
		long[] sum = new long[str.length];
		ArrayList<Integer>[] pos = new ArrayList[26];
		
		for (int i=0; i<26; i++) {
			pos[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<str.length; i++) {
			int ind = str[i] - 'a';
			
			if (i == 0) {
				sum[i] = map[ind];
			} else {
				sum[i] = map[ind] + sum[i-1];
			}
			
			pos[ind].add(i);
		}
		
		long ans = 0;
		for (int i=0; i<26; i++) {
			HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
			
			for (int j : pos[i]) {
				long tmp = j > 0 ? sum[j - 1] : 0;
				
				if (hm.containsKey(tmp)) {
					ans += hm.get(tmp);
				}
				
				hm.put(sum[j], (hm.containsKey(sum[j]) ? hm.remove(sum[j]) + 1 : 1));
			}
		}
		
		out.println(ans);
	}

	public D() {
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
		D solver = new D();
		solver.solve();
		solver.end();
	}
}

