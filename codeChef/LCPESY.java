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

		int test = Integer.parseInt(in.readLine());
		int[] vis = new int[300];
		int[] vis2 = new int[300];

		while(test --> 0){
			Arrays.fill(vis, 0);
			Arrays.fill(vis2, 0);

			char[] str = in.readLine().trim().toCharArray();

			for(char c : str){
				vis[c] ++;
			}

			int res = 0;
			char[] str2 = in.readLine().trim().toCharArray();

			for(char c : str2){
				if(vis[c] > vis2[c]){
					res ++;
				}
				vis2[c] ++;
			}

			out.println(res);
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
