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

		String str = in.readLine();

		int start = 0;
		int curr;
		long ans = 0;
		int len = str.length();

		while((curr = str.indexOf("bear", start)) != -1){
			int actual = curr + 1 - start;
			ans += actual*(len-(curr+3));
			start = curr + 1;
		}
		out.println(ans);

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
