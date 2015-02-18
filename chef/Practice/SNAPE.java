package practice;

import java.util.Scanner;
import static java.lang.Math.sqrt;

public class SNAPE {
	private static Scanner in;
	
	static {
		in = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		int t = in.nextInt();
		
		while (t --> 0) {
			int b = in.nextInt();
			int ls = in.nextInt();
			
			System.out.println(min(b, ls) + " " + max(b, ls));
		}
	}
	
	private static double max(int a, int b) {
		return sqrt(a * a + b * b);
	}
	
	private static double min(int a, int c) {
		return sqrt(c * c - a * a);
	}
}
