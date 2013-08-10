import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		int t = (int) st.nval;
		int[] arr = new int[t];
		for(int i=0;i<arr.length;i++){
			st.nextToken();
			arr[i] = (int)st.nval;
		} int[] dp = new int[t+1];
		int[] dphelp = new int[t+1];
		for(int i=1;i<dp.length;i++){
			dp[i] = Math.max(dp[i-1],dphelp[i-1]+arr[i-1]);
			dphelp[i]  = Math.max(dphelp[i-1], dp[i-1]-arr[i-1]);
		} System.out.println(dp[dp.length-1]);
	}
}
