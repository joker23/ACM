package Jan2015Long;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GCDQ {

	private static BufferedReader in;
	private static StringTokenizer st;
	private static PrintWriter out;
	
	static {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(in.readLine().trim());
		
		while (t --> 0) {
			solve_complex();
		}
		
		out.flush();
		
		in.close();
		out.close();
	}
	
	private static void solve_complex() throws IOException {
		st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n + 1];
		int[] pre = new int[n + 2];
		int[] post = new int[n + 2];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		pre[1] = arr[1];
		
		for (int i = 2; i<=n; i++) {
			pre[i] = gcd(pre[i- 1], arr[i]);
		}
		
		post[n] = arr[n];
		
		for (int i = n; i>=1; i--) {
			post[i] = gcd(post[i + 1], arr[i]);
		}
		
		while (q --> 0) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			out.println(gcd(pre[s - 1], post[t + 1]));
		}
	}
	
	private static void solve_simple() throws IOException {
		st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n + 1];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		while (q --> 0) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			int ans = -1;
			
			for (int i = 1; i<s; i++) {
				if (ans == -1) {
					ans = arr[i];
				} else {
					ans = gcd(ans, arr[i]);
				}
			}
			
			for (int i = t + 1; i <= n; i++) {
				if (ans == -1) {
					ans = arr[i];
				} else {
					ans = gcd(ans, arr[i]);
				}
			}
			
			out.println(ans);
		}
	}
	
	 /*
	  * complex solution makes a complete binary tree... index tree style
	  */
	
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b);
	}
}
