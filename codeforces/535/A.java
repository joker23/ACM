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

public class A {

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	private static HashMap<Character, String> tens;
	private static HashMap<Character, String> ones;
	private static HashMap<Character, String> teen;
	static {
		tens = new HashMap<Character, String>();

		tens.put('2', "twenty");
		tens.put('3', "thirty");
		tens.put('4', "forty");
		tens.put('5', "fifty");
		tens.put('6', "sixty");
		tens.put('7', "seventy");
		tens.put('8', "eighty");
		tens.put('9', "ninety");

		ones = new HashMap<Character, String>();

		ones.put('0', "zero");
		ones.put('1', "one");
		ones.put('2', "two");
		ones.put('3', "three");
		ones.put('4', "four");
		ones.put('5', "five");
		ones.put('6', "six");
		ones.put('7', "seven");
		ones.put('8', "eight");
		ones.put('9', "nine");

		teen = new HashMap<Character, String>();

		teen.put('0', "ten");
		teen.put('1', "eleven");
		teen.put('2', "twelve");
		teen.put('3', "thirteen");
		teen.put('4', "fourteen");
		teen.put('5', "fifteen");
		teen.put('6', "sixteen");
		teen.put('7', "seventeen");
		teen.put('8', "eighteen");
		teen.put('9', "nineteen");

	}
	public void solve() throws Exception {
		char[] n = in.next().toCharArray();

		if (n.length == 1) {
			out.println(ones.get(n[0]));
		} else {
			if (n[0] == '1') {
				out.println(teen.get(n[1]));
			} else {
				String ans = tens.get(n[0]);
				if (n[1] != '0') {
					ans += "-" + ones.get(n[1]);
				}

				out.println(ans);
			}
		}
	}

	public A() {
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
		A solver = new A();
		solver.solve();
		solver.end();
	}
}
