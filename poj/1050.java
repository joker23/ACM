import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] dp = new int[n][n];
		int[] temp = new int[n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				dp[i][j] = in.nextInt();
			}
		}
		int maxEnd,curr,max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			Arrays.fill(temp, 0);
			for(int j=i;j<n;j++){
				maxEnd = 0;
				curr = Integer.MIN_VALUE;
				for(int k=0;k<n;k++){
					temp[k]+=dp[j][k];
					maxEnd = Math.max(0,maxEnd+temp[k]);
					curr = Math.max(curr,maxEnd);
				}
				max = Math.max(max, curr);
			}
		}
		System.out.println(max);
	}
}
