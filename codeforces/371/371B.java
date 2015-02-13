import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	static int ans;
	static Scanner in;
	public static void main(String[] args) throws IOException{
		in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		
		int[] pa = new int[6];
		int[] pb = new int[6];

		while(a%2 == 0){
			a/=2;
			pa[2]++;
		}
		while(a%3 ==0){
			a/=3;
			pa[3]++;
		}
		while(a%5 == 0){
			a/=5;
			pa[5]++;
		}
		while(b%2 == 0){
			b/=2;
			pb[2]++;
		}
		while(b%3 == 0){
			b/=3;
			pb[3]++;
		}
		while(b%5 == 0){
			b/=5;
			pb[5]++;
		}

		if(a==b){
			int ans = Math.abs(pa[2] - pb[2]) + Math.abs(pa[3] - pb[3]) + Math.abs(pa[5]-pb[5]);
			System.out.println(ans);
		}else{
			System.out.println(-1);
		}
	}
}
