import java.util.*;
import java.math.*;
import java.text.*;
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

	// IO Imports
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	private static String words  = "Happy birthday to you Happy birthday to you Happy birthday to Rujia Happy birthday to you";

	public void solve() throws Exception {
		int t = parseInt(in.readLine());

		String[] names = new String[t];
		String[] dict = words.split(" ");

		for(int i=0; i<t; i++) {
			names[i] = in.readLine();
		}

		int times = (int) ceil(((double) names.length) / dict.length);
		for(int i=0; i<dict.length * times; i++) {
			out.println(names[i % names.length] + ": " + dict[i % dict.length]);
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
