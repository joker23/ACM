import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	static Scanner in;
	//static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static ArrayList<Integer> list;
	static HashMap<Integer, Integer> freqTable;

	public static void main(String[] args) throws IOException{
		in = new Scanner(System.in);
		//in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		int n = in.nextInt();
		int ans = in.nextInt();
		for(int i=1; i<n; i++){
			ans = gcd(ans, in.nextInt());
		}
		out.println(ans*n);
		out.flush();
	}

	public static int gcd(int a, int b){
		return (b==0 ? a : gcd(b, a%b));
	}

	public static void print(int[][] dp){
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[i].length; j++){
				System.out.print("["+dp[i][j]+"]");
			}System.out.println();
		} System.out.println();
	}

	public static void print(LinkedList[] graph){
		for(LinkedList li : graph){
			System.out.println(li);
		}
	}

}
