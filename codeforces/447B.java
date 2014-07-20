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

public class Main {

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		char[] str = in.next().toCharArray();
		int n = in.nextInt();

		int[] val = new int[Character.MAX_VALUE];
		int hi = 0;
		for(int i=0; i<26; i++) {
			val['a' + i] = in.nextInt();
			hi = max(hi, val['a' + i]);
		}

		int ans = 0;

		int i;
		for(i=0; i<str.length; i++) {
			ans += val[str[i]] * (i + 1);
		}
		i++;

		for (int j = 0; j < n;j++) {
			ans += hi * (i++);
		}

		out.println(ans);
	}

	public Main() {
		this.in = new Scanner(System.in);
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
