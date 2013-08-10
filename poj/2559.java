import java.io.*;

public class Main{
	static long[] h = new long[1<<18];
	static int[] rS = new int[1<<18];
	static int[] lS = new int[1<<18];

	public static void main(String[] arg) throws Exception{
	    StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	    for(;;){
	    	st.nextToken();
	    	int n = (int) st.nval;
	    	if (n == 0) break;
	    	for (int i=0 ; i<n ; i++){
	    		st.nextToken();
	    		h[i] = (long) st.nval;
	    	}h[n] = 0;
	    	long max_area = 0;
	    	int sp = 0;
	    	for (int i=0 ; i<=n ; i++){
	    		lS[sp] = i;
	    		while (sp > 0 && h[rS[sp-1]] > h[i]){
	    			max_area = Math.max(max_area, (i-lS[--sp])*h[rS[sp]]);
	    		}rS[sp++] = i;
	    	}System.out.println(max_area);
	    }
	}
}