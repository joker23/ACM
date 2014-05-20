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
		int t = in.nextInt();

		while(t --> 0) {
			String str = in.next();
			if(str.length() == 5) {
				out.println(3);
			} else {
				int[] car = new int[Character.MAX_VALUE];

				for(char c : str.toCharArray()) {
					car[c]  = 1;
				}

				if(car['o'] + car['n'] + car['e'] >= 2) {
					out.println(1);
				} else {
					out.println(2);
				}
			}
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
