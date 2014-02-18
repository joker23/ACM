import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	static Scanner in;
	//static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int[] arr;

	public static void main(String[] args) throws IOException{
		in = new Scanner(System.in);
		//in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		arr = new int[n];
		
		for(int i = 0; i < n; i++){
			arr[i] = in.nextInt();
		}

		int m = in.nextInt();
		while(m --> 0){
			int ans = 0;
			int min = in.nextInt();
			for(int i=0; i<n; i++){
				if(arr[i] == min){
					ans += solve(min, i, i);
				}
			}
			out.println(ans);
		}

		out.flush();
	}

	private static int solve(int min, int left, int right){
		
		int dr = right + 1, dl = left - 1;
		int ans = 0;

		while(dr < arr.length && arr[dr] > min){
			dr ++;
		} dr --;
		dr -= right;

		while(dl >= 0 && arr[dl] > min){
			dl --;
		} dl ++;
		dl = left - dl;

		if(dr + 1 + right < arr.length && arr[right + dr+1] == min){
			ans += solve(min, left, right + dr+1);
		}

		return (1+dr) * (1+dl) + ans;

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
