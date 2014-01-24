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

		st = new StringTokenizer(in.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine().trim());
		int[] x = new int[n];
		for(int i=0; i<n ; i++){
			x[i] = Integer.parseInt(st.nextToken());
		}

		int maxdiff = 0;
		for(int i=1; i<n; i++){
			maxdiff = Math.max(x[i-1] - x[i], maxdiff);
		}

		out.println(Math.max(maxdiff-c,0));		

		out.flush();
	}

	public static void print(int[][] dp){
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[i].length; j++){
				System.out.print("["+dp[i][j]+"]");
			}System.out.println();
		} System.out.println();
	}
}
