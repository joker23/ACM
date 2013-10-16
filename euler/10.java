import java.util.*;

public class Main{

	public static void main(String[] args){
		boolean[] dp = new boolean[2000000];
		Arrays.fill(dp,true);
		dp[0] = dp[1] = false;
		long ans = 0;
		for(int i = 2; i< dp.length; i++){
			if(dp[i]){
				ans += i;
				for(int j = i+i; j<dp.length; j+=i){
					dp[j] = false;
				}
			}
		}System.out.println(ans);
	}
}
