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

public class C {

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		List<Integer> list = new ArrayList<Integer>();
		int n = in.nextInt();
		char[] str = in.next().toCharArray();

		for (int i=0; i<n; i++) {
			int tmp = str[i] - '0';

			if (tmp <= 1) {
				// do nothing
			} else {
				if (tmp == 4){
					list.add(2);
					list.add(2);
					list.add(3);
				} else if (tmp == 8){
					list.add(2);
					list.add(2);
					list.add(2);
					list.add(7);
				} else if (tmp == 6){
					list.add(3);
					list.add(5);
				} else if(tmp == 9) {
					list.add(7);
					list.add(3);
					list.add(3);
					list.add(2);
				} else{
					list.add(tmp);
				}
			}
		}

		Collections.sort(list);

		while (!list.isEmpty()) {
			out.print(list.remove(list.size() - 1));
		}
		out.println();
	}

	public C() {
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
		C solver = new C();
		solver.solve();
		solver.end();
	}
}
