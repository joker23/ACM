
import java.util.*;

public class Main{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int n;
		while((n = in.nextInt()) > 0){
			int[] arr = new int[n];
			int[] dp = new int[n];
			int min = 0;
			int max = Integer.MIN_VALUE;
			for(int i=0; i< n; i++){
				arr[i] = in.nextInt();
				max = Math.max(max, arr[i]);
			}
			min = Math.min(min, arr[0]);
			dp[0] = arr[0];
			for(int i = 1; i< n; i++){
				dp[i] = arr[i] + dp[i-1];
				max = Math.max(dp[i] - min, max);
				min = Math.min(dp[i], min);
			}
		
			System.out.println(max);
		}

	}
}
