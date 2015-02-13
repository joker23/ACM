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

	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	public void solve() throws Exception {
		st = new StringTokenizer(in.readLine());
		double a = parseDouble(st.nextToken());
		double d = parseDouble(st.nextToken());
		DecimalFormat fmt = new DecimalFormat("0.0000000000");

		int n =parseInt(in.readLine().trim());

		for(int i=1; i<=n; i++) {
			double linPos = i * d;

			double lap = linPos%(4*a);

			if(lap <= a)
				out.println(fmt.format(lap) + " " + fmt.format(0));
			else if(lap <= 2*a)
				out.println(fmt.format(a) + " " + fmt.format(lap - a));
			else if(lap <= 3*a)
				out.println(fmt.format(a - (lap - 2*a)) + " " + fmt.format(a));
			else if(lap <= 4*a)
				out.println(fmt.format(0) + " " + fmt.format(a - (lap - 3*a)));
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
