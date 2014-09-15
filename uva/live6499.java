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
		int n;
		int number = 0;
		while ((n = in.nextInt()) > 0) {
			char[] table = new char[Character.MAX_VALUE];
			char[] c = in.next().toCharArray();
			for(int i=0; i<26; i++) {
				table[c[i]] = (char) ('A' + i);
			}
			number ++;

			words[] stuff = new words[n];
			for (int i=0; i<n; i++) {
				String w = in.next();
				String k = "";

				for (int j=0; j<w.length(); j++) {
					k += table[w.charAt(j)];
				}

				stuff[i] = new words(k, w);
			}

			sort(stuff);
			out.println("year " + number);
			for(words s : stuff) {
				out.println(s.word);
			}
		}
	}

	public class words implements Comparable<words> {
		String key;
		String word;

		public words(String key, String word){
			this.key = key;
			this.word = word;
		}

		public int compareTo(words w) {
			return this.key.compareTo(w.key);
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
