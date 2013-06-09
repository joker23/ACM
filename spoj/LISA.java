import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(in.readLine().trim());
		long dpMax[][],dpMin[][];
		int count1,count2,n;
		boolean isMult[];
		String curr;
		while(test-->0){
			curr = in.readLine().trim();
			dpMax = new long[curr.length()/2+1][curr.length()/2+1];
			dpMin = new long[curr.length()/2+1][curr.length()/2+1];
			isMult = new boolean[curr.length()/2];
			count1 = count2 = 0;
			for(int i=0;i<curr.length();i++){
				if(curr.charAt(i)=='*')isMult[count1++] = true;
				else if(curr.charAt(i)=='+') count1++;
				else{
					dpMax[count2][count2] = dpMin[count2][count2++] = (int)curr.charAt(i) - '0'; 
				}
			}n = dpMin.length;
			for(int a = 1; a < n; a++)
				for(int b = 0; b < n-a; b++){
					int i = b, j = b+a;
					dpMin[i][j] =Long.MAX_VALUE;
					dpMax[i][j] =Long.MIN_VALUE;
					for(int k = i; k < j; k++){
						dpMin[i][j] = Math.min(dpMin[i][j],calc(dpMin,isMult,i,j,k));
						dpMax[i][j] = Math.max(dpMax[i][j],calc(dpMax,isMult,i,j,k));
					}
				}

			System.out.println(dpMax[0][n-1]+" "+dpMin[0][n-1]);
		}
	}
	private static long calc(long[][] dp, boolean[]isMult,int i, int j, int k){
		long ret = 0;
		ret = isMult[k]? dp[i][k]*dp[k+1][j]:dp[i][k]+dp[k+1][j];
		return ret;
	}
}
	
