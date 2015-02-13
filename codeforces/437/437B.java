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
		int sum = in.nextInt();
		int limit = in.nextInt();

		int ans = 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i=limit; i>0; i--) {
			int bit = i & (- i);
			if (ans + bit <= sum) {
				ans += bit;
				list.add(i);
			}
		}

		if (ans == sum) {

			out.println(list.size());
			boolean first = true;
			while (!list.isEmpty()) {
				if (!first) {
					out.print(" ");
				}

				out.print(list.poll());

				first = false;
			}

		} else {
			out.println(-1);
		}
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
