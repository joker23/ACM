import java.util.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), A =in.nextInt(), B = in.nextInt();
		int[][] dp = new int[N][N];
		for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], INF);
		for(int i=0;i<N;i++){
			int num = in.nextInt();
			for(int j=0;j<num;j++){
				if(j==0) dp[i][in.nextInt()-1] = 0;
				else dp[i][in.nextInt()-1] = 1;
			}
		}
		for (int k = 0;k<dp.length; k++)
			for (int i = 0; i < dp.length; i++)
				if (dp[i][k] != Integer.MAX_VALUE)
					for ( int j = 0; j < dp.length; j++ )
				 	if ( dp[k][j] != Integer.MAX_VALUE)
				 	dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] );
		int ret = dp[A-1][B-1];
		if(ret<Integer.MAX_VALUE)System.out.println(ret); 
		else System.out.println(-1);
	}
}
