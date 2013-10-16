
import java.util.*;

public class Main{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] dp = new int[n+1];
		int[] prev = new int[n+1];

		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=i; j++){
				int temp = in.nextInt();
				dp[j] = Math.max(temp+prev[j], temp+prev[j-1]);
			}
			for(int j = 0; j<=n; j++){
				prev[j] = dp[j];
			}
		}
		
		int ans = Integer.MIN_VALUE;
		for(int i: dp){
			ans = Math.max(ans, i);
		}
		System.out.println(ans);
	}
}
