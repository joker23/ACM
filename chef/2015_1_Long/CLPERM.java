package Jan2015Long;

import java.util.HashSet;
import java.util.Scanner;

public class CLPERM {

	public static void main(String[] args) {
		knapsack_solution();
	}

	/*
	 * this will give nze
	 */
	private static void knapsack_solution() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();

			HashSet<Integer> missing = new HashSet<Integer>();
			int sum = n * (n + 1) / 2;

			for (int i = 0; i < k; i++) {
				int tmp = in.nextInt();
				sum -= tmp;
				missing.add(tmp);
			}

			boolean[] dp = new boolean[sum + 10];

			dp[0] = true;

			for (int i = 1; i <= n; i++) {
				if (!missing.contains(i)) {
					for (int j = sum; j >= i; j--) {
						if (dp[j - i]) {
							dp[j] = true;
						}
					}
				}
			}

			int first = 0;

			for (; first <= sum && dp[first]; first++)
				;

			if (first % 2 == 0) {
				System.out.println("Mom");
			} else {
				System.out.println("Chef");
			}
		}
	}
}
