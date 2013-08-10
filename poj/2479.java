import java.io.*;
import java.util.*;
public class Main {
//NEED TO HANDLE ALLL NEGATIVE INPUT!!
	static int pivot,numEl,board[],forward[],reverse[],dp[], INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int nt = Integer.parseInt(in.readLine().trim());
		while(nt-->0){
			in.readLine();
			numEl = Integer.parseInt(in.readLine().trim());
			board =  new int[numEl];
			dp = new int[numEl];
			forward = new int[numEl];
			reverse = new int[numEl+1];
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<numEl;i++) board[i] = Integer.parseInt(st.nextToken());
			dp[0] = board[0];
			for(int i=1;i<board.length;i++){
				dp[i] = Math.max(board[i],dp[i-1]+board[i]);
			} forward[0] = board[0];
			for(int i=1;i<board.length;i++){
				forward[i] = Math.max(dp[i], forward[i-1]);
			} dp[numEl-1] = board[numEl-1];
			for(int i=numEl-2;i>=0;i--){
	            dp[i] = Math.max(dp[i+1] + board[i], board[i]);
			} reverse[numEl-1] = dp[numEl-1];
			for(int i=numEl-2;i>=0;i--){
				reverse[i] = Math.max(dp[i], reverse[i+1]);
			} long max = (long) -INF;
			reverse[numEl] = -INF;
			for(int i=0;i<board.length;i++){
				max = Math.max(max,(long)(forward[i]+reverse[i+1]));
			}System.out.println(max);
		}
	}
	private static void print(int[] arr){
		for(int i : arr){
			System.out.print(i+" ");
		}System.out.println();
	}
}
