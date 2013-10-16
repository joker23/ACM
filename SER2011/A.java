import java.util.*;

public class Main{
	static Scanner in;
	public static void main(String[] args){
		in = new Scanner(System.in);
		int n;
		double m;
		while((n=in.nextInt()) + (m=in.nextDouble()) > 0){		
			int[] dp = new int[(int)(m*100)+1];
			Arrays.fill(dp, -1);
			dp[0] = 0;
			int ans = 0;
			for(int num = 0; num < n; num++){
				int c = in.nextInt();
				int p = (int)(in.nextDouble()*100);
				for(int i = p; i<dp.length; i++){
					if(dp[i-p]>-1){
						dp[i] = Math.max(dp[i],dp[i-p]+c);
						ans = Math.max(ans,dp[i]);
					}
				}
			}System.out.println(ans);
		}
	}
}
