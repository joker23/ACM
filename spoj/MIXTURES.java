import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n;
		String temp;
		while((temp = in.readLine()) != null){
			n = Integer.parseInt(temp);
			StringTokenizer st = new StringTokenizer(in.readLine());
			int[] mixture = new int[100];
			for(int i = 0; i < n; i++)
				mixture[i] = Integer.parseInt(st.nextToken());
			int[][] c = new int[n][n];
			int[][] s = new int[n][n]; 
			for(int i = 0; i < n; i++)
				c[i][i] = mixture[i];
			for(int a = 1; a < n; a++)
			  for(int b = 0; b < n-a; b++){
				  int i = b, j = b+a;
				  s[i][j] = Integer.MAX_VALUE;
				  int mink = 0;
				  for(int k = i; k < j; k++)
				    if((c[i][k]*c[k+1][j] + s[i][k] + s[k+1][j])< s[i][j]){
				    		s[i][j] = c[i][k]*c[k+1][j] + s[i][k] + s[k+1][j];
				    		mink = k;
				    }c[i][j] = (c[i][mink] + c[mink+1][j])%100;
			  }
			  System.out.println(s[0][n-1]);
		}
	}
}
