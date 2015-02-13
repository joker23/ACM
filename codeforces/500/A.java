package practice;
import java.util.Scanner;


public class A500 {

	public static Scanner in;
	private static final String YES = "YES";
	private static final String NO = "NO";

	static {
		in = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] dx = new int[n];
		
		for (int i=1; i<n; i++) {
			dx[i] = in.nextInt();
		}
		
		for (int i=1; i <= m;) {
			if (i == m) {
				System.out.println(YES);
				return;
			}
			i += dx[i];
		}
		
		System.out.println(NO);
	}
}
