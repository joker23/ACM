import java.util.*;
import java.io.*;
public class Main{
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken()),m = Integer.parseInt(st.nextToken()),u,d,
				ans = INF;
		while(m-->0){
			st = new StringTokenizer(in.readLine());
			u = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			int x = d*n/(u+d)+1;
            ans = Math.min(ans,(u+d)*x-d*n);
		}System.out.println(ans);
	}
}
