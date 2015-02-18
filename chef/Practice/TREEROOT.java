package practice;

import java.util.Scanner;

public class TREEROOT {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		while (t --> 0) {
			int a = 0;
			int b = 0;
			
			int n = in.nextInt();
			
			while (n --> 0) {
				a += in.nextInt();
				b += in.nextInt();
			}
			
			System.out.println(a - b);
		}
	}
}
