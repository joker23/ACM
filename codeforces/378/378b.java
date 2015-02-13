import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	//static Scanner in;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;

	public static void main(String[] args) throws IOException{
		
		//in = new Scanner(System.in);
		in = new BufferedReader(new InputStreamReader( System.in));
		out = new PrintWriter(System.out);

		//code starts here
		int n = Integer.parseInt(in.readLine().trim());	
		
		int[] a = new int[n];
		int[] b = new int[n];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(in.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		/**
		 * algorithm idea..
		 * we only need to worry about 2 cases
		 * either k = 0 which is the most liberal case
		 * or k = n/2 now we need to look at whether n is odd
		 */
		boolean[] ansa0 = new boolean[n]; // what if k = 0
		boolean[] ansb0 = new boolean[n];
		boolean[] ansa1 = new boolean[n];
		boolean[] ansb1 = new boolean[n]; // what if k = n/2

		int ptra = 0; // first semifinal
		int ptrb = 0;

		for(int i=0; i<n; i++){
			if(a[ptra] < b[ptrb]){
				ansa0[ptra++] = true;
			} else {
				ansb0[ptrb++] = true;
			}
		}
		
		int i;
		for(i=0; i < n/2; i++){
			ansa1[i] = true;
			ansb1[i] = true;
		}

		if(i<(n+1)/2){
			if(a[i] < b[i]){
				ansa1[i] = true;
			} else{
				ansb1[i] = true;
			}
		}
		
		//print(ansa0);
		//print(ansb0);
		//print(ansa1);
		//print(ansb1);

		print(ansa0, ansa1);
		print(ansb0, ansb1);
		//code ends here
		out.flush();
	}

	private static void print(boolean[] arr1, boolean[] arr2){
		for(int i=0;i<arr1.length; i++){
			boolean tmp = arr1[i]|arr2[i];
			out.print(tmp? 1:0);
		}
		out.println();
	}
}
