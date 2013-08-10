import java.util.*;
public class Main {
	private static final int MAX = 26;
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		String curr;
		long[] dp;
		int[] num;
		int n;
		for(;;){
			curr = in.next();
			if(curr.equals("0")) break;
			n = curr.length();
			num = new int[curr.length()];
			for(int i=0;i<curr.length();i++)
				num[i] = (int)curr.charAt(i)-(int)'0';
			dp = new long[curr.length()+1];
			if(num[n-1]>0) dp[n-1] = 1;
			if(num.length>=2&&num[n-2]*10+num[n-1]<=MAX&&num[n-2]>0) dp[n-2] = 1;
		
			for(int i=n-2;i>=0;i--){
				if(num[i]>0){
					dp[i] += dp[i+1];
					if(num[i]*10+num[i+1]<=MAX) dp[i] += dp[i+2];
				}
			} System.out.println(dp[0]);
		}
	}
}
