import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	static Scanner in;	
	public static void main(String[] args) throws IOException{
		in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = in.nextInt();
		}

		int div = n/k;
		int[][] store = new int[div+1][k];
		int ptr = 0;
		for(int i=0;i<div;i++){
			for(int j=0;j<k;j++){
				store[i][j] = arr[ptr++];
			}
		}
		
		int a,b;
		for(int i=0;i<k;i++){
			a = b = 0;
			for(int j = 0;j<div;j++){
				if(store[j][i] == 1){
					a++;
				} else{
					b++;
				}
			}
			store[div][i] = Math.min(a,b);
		}

		int ans = 0;
		for(int i=0;i<k;i++){
			ans+=store[div][i];
		}

		System.out.println(ans);
	}
}
