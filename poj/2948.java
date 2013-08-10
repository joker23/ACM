import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n,m,goingUp[][],goingLeft[][],dpUp[][],dpLeft[][],i,j;
		for(;;){
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			goingLeft = new int[n+1][m+1];
			goingUp = new int[n+1][m+1];
			dpLeft = new int[n+1][m+1];
			dpUp = new int[n+1][m+1];
			if(n+m==0) break;
			for(i=1;i<=n;i++)
				for(st = new StringTokenizer(in.readLine()),j=1;j<=m;j++)
					goingLeft[i][j] = goingLeft[i][j-1]+Integer.parseInt(st.nextToken());
			for(i=1;i<=n;i++)
				for(st = new StringTokenizer(in.readLine()),j=1;j<=m;j++)
					goingUp[i][j] = goingUp[i-1][j] + Integer.parseInt(st.nextToken());
			for(i=1;i<=n;i++)
				for(j =1;j<=m;j++){
					dpLeft[i][j] = goingLeft[i][j] + Math.max(dpLeft[i-1][j],dpUp[i-1][j]);
					dpUp[i][j] = goingUp[i][j] + Math.max(dpUp[i][j-1],dpLeft[i][j-1]);
				}
			System.out.println(Math.max(dpUp[n][m], dpLeft[n][m]));
		}
	}
}
