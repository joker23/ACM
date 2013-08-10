import java.util.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		int[] dp = new int[m+1];
		while(n-->0){
			int w = in.nextInt(),d = in.nextInt();
			for(int i=m;i>=w;i--){
				dp[i] = Math.max(dp[i],dp[i-w]+d);
			}
		}System.out.println(dp[m]);
	}
}
