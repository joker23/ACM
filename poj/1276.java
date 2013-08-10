import java.util.*;
import java.io.*;
public class Main {
	static int nMax = 100;
	public static void main(String[] args) throws IOException{
		int cash, t, i, k, n, v, val[] =  new int[nMax];
		boolean[] dp; 
		Scanner in = new Scanner(System.in);
		in.useDelimiter("\\s+");
		while(true){
			cash = in.nextInt();
			t = in.nextInt();
		    int count = 0;
		    while(t-->0){
		    	n = in.nextInt();
		        v = in.nextInt();
		        k = 1;    
		        while (n - k >= 0){
		        	val[count++] = v * k;
		            n -= k;
		            k *= 2;
		        } if(n>0) val[count++] = v * n;
		    } dp = new boolean[cash+1];
		    dp[0] = true;   
		    for(i = 0; i < count; i ++)   
		    	for(k = cash; k >= val[i]; k --)
		    		if(dp[k - val[i]])
		    			dp[k] = true;
		    int ans = cash;
		    while(!dp[ans]) ans --;
		    System.out.println(ans);
		    if(!in.hasNext()) break;
		}
	}
}
