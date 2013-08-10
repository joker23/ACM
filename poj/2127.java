import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String ans[] = new String[501];
		int arr1[],arr2[],m,ptr=0,dp[][];
		m = Integer.parseInt(in.readLine().trim());
		arr1 = new int[m];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<m;i++)
			arr1[i] = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(in.readLine().trim());
		arr2 = new int[m];
		dp= new int[arr1.length+1][arr2.length+1];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<m;i++)
			arr2[i] = Integer.parseInt(st.nextToken());
		for(int i=1;i<dp.length;i++)
			for(int j=1;j<dp[i].length;j++){
				if(arr1[i-1]==arr2[j-1]) dp[i][j] += dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(Math.max(Math.max(dp[i][j], dp[i-1][j-1]),dp[i-1][j]),dp[i][j-1]);
			}
		print(dp);
	}
	private static void print(int[][] arr){
		for(int i=0;i<arr.length;i++){
				for(int j=0;j<arr[i].length;j++){
					System.out.print("["+arr[i][j]+"]");
				}System.out.println();
		}System.out.println();
	}
}
