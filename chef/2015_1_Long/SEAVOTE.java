package Jan2015Long;

import java.util.Scanner;

public class SEAVOTE {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		while (t --> 0) {
			int n = in.nextInt();
			int sum = 0;
			int count = 0;
			
			for (int i=0; i<n; i++) {
				int num = in.nextInt();
				if (num != 0) {
					count ++;
				}
				sum += num;
			}
			
			if (sum < 100) {
				System.out.println("NO");
			} else {
				if (sum - count < 100) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
