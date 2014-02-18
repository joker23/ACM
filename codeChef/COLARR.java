import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	//IO tools
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;

	//static variables
	static int a[],b[][], c[][], n, m, k;

	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		//code starts here
		int test = Integer.parseInt(in.readLine().trim());

		while(test --> 0){
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
		
			a = new int[n];
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++){
				a[i] = Integer.parseInt(st.nextToken()) - 1;
			}

			b = new int[n][m];
			for(int i=0; i<n; i++){
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<m; j++){
					b[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			c = new int[n][m];
			for(int i=0; i<n; i++){
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<m; j++){
					c[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int res = 0;
			for(int i=0; i<n; i++){
				res += b[i][a[i]];
			}
			
			int[] gain = new int[n];
			for(int i=0; i<n; i++){
				int best = 0;
				for(int j=0; j<m; j++){
					if(j != a[i])
						best = Math.max(best, b[i][j] - c[i][j] - b[i][a[i]]);
				}
				gain[i] = best;
			}

			Arrays.sort(gain);

			for(int i=0; i<k && i<n; i++){
				int tmp = gain[n- i - 1];
				if(tmp <= 0){
					break;
				}
				res += tmp;
			}

			out.println(res);
		}

		//code ends here
		out.flush();
	}

	//helper functions
}
