import java.util.*;
import java.math.*;
import java.io.*;
import java.awt.*;

public class Main {
	
	//IO tools
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;

	//static variables
	static int[] a, b;
	static boolean[] vis;

	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		//code starts here
		int t = Integer.parseInt(in.readLine().trim());

		while (t --> 0) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			a = new int[n];
			b = new int[n];
			vis = new boolean[n];
			
			st = new StringTokenizer(in.readLine());
			for (int i=0; i<n; i++){
				a[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(in.readLine());
			for (int i=0; i<n; i++){
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(b);

			boolean ans = true;
			for(int i=0; i<n; i++){
				int target = k - a[i];
				boolean found = false;
				for(int j=0; j<n; j++){
					if(b[j] >= target && !vis[j]){
						vis[j] = true;
						found = true;
						break;
					}
				}

				if(!found){
					ans = false;
					break;
				}
			}
			
			out.println(ans ? "YES" : "NO");
		}
		
		//code ends here
		out.flush();
	}

	//helper functions
}
