package practice;
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

public class NAME2 {

	// IO Imports
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int t = Integer.parseInt(in.readLine());
		
		while (t --> 0) {
			st = new StringTokenizer(in.readLine());
			
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			// str1 is longer
			if (str1.length() < str2.length()) {
				String tmp = str1;
				str1 = str2;
				str2 = tmp;
			}
			
			int ptr1 = 0;
			int ptr2 = 0;
			
			for (;ptr2 < str2.length() && ptr1 < str1.length(); ptr1 ++) {
				if (str1.charAt(ptr1) == str2.charAt(ptr2)) {
					ptr2 ++;
				}
			}
			
			String ans = ptr2 == str2.length() ? "YES" : "NO";
			out.println(ans);
		}
	}

	public NAME2() {
		this.in = new BufferedReader(new InputStreamReader(System.in));
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
		NAME2 solver = new NAME2();
		solver.solve();
		solver.end();
	}
}

