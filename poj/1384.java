import java.util.*;
import java.io.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		int num = in.nextInt();
		while(num-->0){
			int weight = Math.abs(in.nextInt() - in.nextInt());
			if(weight==0){
				System.out.println("This is impossible.");
				continue;
			}
			int[] dp = new int[weight+1];
			Arrays.fill(dp,INF);
			dp[0] = 0;
			int coins = in.nextInt();
			while(coins-->0){
				int value = in.nextInt();
				int w = in.nextInt();
				for(int i=w;i<dp.length;i++){
					dp[i] =Math.min(dp[i-w]+value, dp[i]);
				}
			}
			if(dp[dp.length-1]<INF) System.out.println("The minimum amount of money in the piggy-bank is "+dp[dp.length-1]+".");
			else System.out.println("This is impossible.");
		}
		
	}

}
