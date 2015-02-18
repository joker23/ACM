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

public class C {

	// IO Imports
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	private Node root;
	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		st = new StringTokenizer(in.readLine());
		int n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());
		this.root = new Node();

		for (int i=0; i<n; i++) {
			add(in.readLine());
		}

		while (m --> 0) {
			if (walk(in.readLine().trim(), 0, root, 0)) {
				out.println("YES");
			} else {
				out.println("NO");
			}
		}
	}

	private boolean walk(String str, int index, Node curr, int m) {
		if (m > 1) {
			return false;
		} else if (index == str.length() && m == 1 && curr.isLeaf) {
			return true;
		} else if (index == str.length()){
			return false;
		}

		boolean ans = false;

		for (int i=0; i < curr.next.length; i++) {
			if (curr.next[i] == null) {
				continue;
			}

			int offset = (i == str.charAt(index) - 'a') ? 0 : 1;
			ans |= walk(str, index + 1, curr.next[i], m + offset);
		}

		return ans;
	}

	private void add(String str) {
		Node curr = root;
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (curr.next[c - 'a'] != null) {
				curr = curr.next[c - 'a'];
			} else {
				Node n = new Node();
				curr.next[c - 'a'] =  n;
				curr = n;
			}
		}

		curr.isLeaf = true;
	}

	private class Node {
		Node[] next;
		boolean isLeaf;

		public Node() {
			this.next = new Node[3];
			this.isLeaf = false;
		}
	}

	public C() {
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
		C solver = new C();
		solver.solve();
		solver.end();
	}
}
