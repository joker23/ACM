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

public class B {

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	private DecimalFormat fmt = new DecimalFormat("0.0000000000");
	private Node root;
	public void solve() throws Exception {
		int n = in.nextInt();

		int[] lights = new int[(1 << (n + 1)) - 2];

		for (int i=0; i<lights.length; i++) {
			lights[i] = in.nextInt();
		}

		root = new Node();

		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);
		int i = 0;

		while (!q.isEmpty() && i < lights.length) {
			Node curr = q.poll();
			curr.l = new Node();
			curr.l.val = lights[i++];
			curr.r = new Node();
			curr.r.val = lights[i++];

			q.add(curr.l);
			q.add(curr.r);
		}
		System.out.println(dfs(root));
	}

	int counter = 0;

	private int dfs(Node curr) {
		if (curr.l == null && curr.r == null) {
			return 0;
		}

		int ret = dfs(curr.l) + dfs(curr.r);

		ret += abs(curr.l.val - curr.r.val);

		curr.val += max(curr.l.val, curr.r.val);

		return ret;
	}

	private class Node {
		int val;
		Node r, l;
	}

	public B() {
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
		B solver = new B();
		solver.solve();
		solver.end();
	}
}
