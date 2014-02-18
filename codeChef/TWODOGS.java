import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	//static Scanner in;
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
	 	//in = new Scanner(System.in);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		int cache[][] = new int[2][1000001];
		for(int i=0; i<cache.length; i++){
			Arrays.fill(cache[i], -1);
		}
		st = new StringTokenizer(in.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(in.readLine().trim());
		for(int i=0; i<n; i++){
			int tmp = Integer.parseInt(st.nextToken());
			
			if(cache[0][tmp] == -1){
				cache[0][tmp] = i + 1;
				cache[1][tmp] = i + 1;
			} else {
				cache[1][tmp] = i + 1;
			}

			arr[i] = tmp;
		}

		int min = 1000001;
		for(int i=0; i<n ; i++){
			int want = m - arr[i];
			if(want < 0 || cache[0][want] == -1 || want == arr[i]){
				continue;
			}
			min = Math.min(min, Math.max(Math.min(i+1, n - i + 1), Math.min(cache[0][want], n - cache[1][want] + 1)));

		}

		if(min == 1000001){
			out.println(-1);
		} else{
			out.println(min);
		}

		out.flush();
	}

	public static void print(int[][] dp){
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[i].length; j++){
				System.out.print("["+dp[i][j]+"]");
			}System.out.println();
		} System.out.println();
	}

	public static void print(boolean[][] dp){
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[i].length; j++){
				System.out.print("["+(dp[i][j] ? 1 : 0)+"]");
			}System.out.println();
		} System.out.println();
	}

	public static void print(int[] dp){
		for(int i : dp){
			System.out.print("[" + i + "]");
		} System.out.println();
	}

	public static void print(LinkedList[] graph){
		for(LinkedList li : graph){
			System.out.println(li);
		}
	}

}
