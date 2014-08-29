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
		int n = in.nextInt();
		int k = in.nextInt();

		char[] arr = in.next().toCharArray();

		Card[] cards = new Card[26];
		for(int i = 0; i < 26; i++) {
			cards[i] = new Card();
			cards[i].id = (char)('A' + i);
		}

		for (char c : arr) {
			cards[c - 'A'].num ++;
		}

		sort(cards);

		long ans = 0;
		int ptr = 0;
		while(k > 0) {
			Card curr = cards[ptr++];
			long tmp = min(k, curr.num);
			ans += tmp * tmp;

			k -= tmp;
		}

		out.println(ans);
	}

	private class Card implements Comparable<Card> {
		char id;
		int num = 0;

		public int compareTo(Card c) {
			return c.num - this.num;
		}

		public String toString() {
			return "" + id + " : " + num;
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
