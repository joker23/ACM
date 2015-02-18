package Jan2015Long;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
 * solve this with max flow
 */
public class ONEKING {
	private final static int MAX_N = 10;
	private static int[][] flow;
	private static Scanner in;
	
	static {
		in = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		int t = in.nextInt();
		
		while (t --> 0) {
			simple2();
			//System.out.println(simple());
		}
	}
	
	private static void simple2() {
		int n = in.nextInt();
		
		int ans = 0;
		
		PriorityQueue<Inteval> pq = new PriorityQueue<Inteval>();
		
		while (n --> 0) {
			pq.add(new Inteval(in.nextInt(), in.nextInt()));
		}
		
		while (!pq.isEmpty()) {
			int curr_t = pq.poll().t;
			ans ++;
			while (!pq.isEmpty() && pq.peek().s <= curr_t) {
				curr_t = Math.min(curr_t, pq.poll().t);
			}
		}
		
		System.out.println(ans);
	}
	
	private static class Inteval implements Comparable<Inteval>{
		
		int s;
		int t;
		
		public Inteval(int s, int t) {
			this.s = s;
			this.t = t;
		}
		
		public int compareTo(Inteval i) {
			return this.s - i.s;
		}
	}
	
	private static void print(int[][] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print("[" + arr[i][j] + "]");
			} System.out.println();
		} System.out.println();
	}
	
	private static int simple() {
		int n = in.nextInt();
		int s = 0;
		int t = MAX_N + n + 1;
		
		flow = new int[n + MAX_N + 2][n + MAX_N + 2];
		
		for (int i=1; i<=n; i++) {
			flow[0][i] = 1;
		}
		
		for (int i = n + 1; i < t; i ++) {
			flow[i][t] = 1;
		}
		
		for (int i = 1; i<=n; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			
			for (int j = start; j <= end; j++) {
				flow[i][j] = 1;
			}
		}
		
		print(flow);
		
		// start max flow
		int ans = 0;
		int[] prev = new int[flow.length];
		Queue<Integer> q = new LinkedList<Integer>();
		
		while (true) {
			Arrays.fill(prev, -1);
			q.clear();
			
			q.add(s);
			
			while (!q.isEmpty() && prev[t] == -1) {
				int u = q.poll();
				for (int v = 1; v<flow.length; v++) {
					if (prev[v] == -1 && flow[u][v] > 0) {
						prev[v] = u;
						q.add(v);
					}
				}
			}
			
			if (prev[t] == -1) {
				break;
			}
			
			for (int v = t, u = prev[v]; u != -1; v = u, u = prev[v]) {
				flow[u][v] = 0;
				flow[v][u] = 1;
			}
			
			ans += 1;
		}
		
		return ans;
	}
}
