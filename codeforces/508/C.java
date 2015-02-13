package r288B;

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

	// IO Imports
	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	// Pretty Stuff
	private DecimalFormat fmt = new DecimalFormat("0.0000000000");

	public void solve() throws Exception {
		int m = in.nextInt();
		int t = in.nextInt();
		int r = in.nextInt();
		
		Queue<Integer> ghost = new LinkedList<Integer>();
		PriorityQueue<Integer> candle = new PriorityQueue<Integer>();
		
		while (m --> 0) {
			ghost.add(in.nextInt());
		}
		
		int ans = 0;
		
		boolean possible = true;
		
		while (!ghost.isEmpty()) {
			int curr = ghost.poll();
			
			while(!candle.isEmpty() && candle.peek() + t < curr) {
				candle.poll();
			}
			
			if (candle.size() >= r) {
				continue;
			}
			
			for (int i = 1; i<=r && candle.size() < r; i++) {
				if (!candle.contains((Integer) (curr - i)) && (curr - i) + t >= curr) {
					ans ++;
					candle.add(curr - i);
				}
			}
			
			if (candle.size() < r) {
				possible = false;
				break;
			}
		}
		
		if (possible) System.out.println(ans);
		else System.out.println(-1);
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
		} catch (Exception e) {
			//do nothing then :)
		}
	}

	public static void main(String[] args) throws Exception {
		C solver = new C();
		solver.solve();
		solver.end();
	}
}

