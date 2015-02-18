package Jan2015Long;

import java.util.Scanner;

public class CHEFSTON {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		while (t-- > 0) {

			int n = in.nextInt();
			int k = in.nextInt();

			int[] time = new int[n];
			int[] profit = new int[n];

			for (int i = 0; i < n; i++) {
				time[i] = in.nextInt();
			}

			long ans = 0;
			for (int i = 0; i < n; i++) {
				profit[i] = in.nextInt();

				ans = Math.max(ans, ((long)(k / time[i])) * profit[i]);
			}

			System.out.println(ans);
		}
	}
}
