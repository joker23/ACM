package practice;
import java.util.Scanner;


public class XORSUB {

	private static Scanner in;
	
	static {
		in = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		int t = in.nextInt();
		
		while (t --> 0) {
			System.out.println(easy());
		}
	}
	
	private static int easy() {
		int ret = 0;
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		int max = m;
		
		for (int i=0; i < (1<<n); i++) {
			int tmp = m;
			for (int j=0; j<n; j++) {
				if ((i & (1<<j)) > 0) {
					tmp ^= arr[j];
				}
			}
			
			max = Math.max(max, tmp);
		}
		
		return max;
	}
}
