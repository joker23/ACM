import java.io.*;
import java.util.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		int test = (int) st.nval,e,f,n,w,p,dp[];
		while(test-->0){
			st.nextToken();
			e = (int) st.nval; st.nextToken();
			f = (int) st.nval; st.nextToken();
			dp = new int[f-e+1];
			Arrays.fill(dp,INF);
			dp[0] = 0;
			n = (int) st.nval;
			while(n-->0){
				st.nextToken();
				p = (int) st.nval;st.nextToken();
				w = (int) st.nval;
				for(int i=w;i<dp.length;i++){
					if(dp[i-w]!=INF)
						dp[i] = Math.min(dp[i-w]+p,dp[i]);
				}
			}if(dp[f-e]<INF) System.out.println("The minimum amount of money in the piggy-bank is "+dp[f-e]+".");
			else  System.out.println("This is impossible.");
		} 
		
	}
	
}
