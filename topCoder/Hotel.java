import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.awt.Point;

import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Long.*;
import static java.lang.Short.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Collections.*;

public class Hotel {
	int inf = 10000000;
	public int marketCost(int minCustomers, int[] customers, int[] cost) {
		int[] dp = new int[100001];

		fill(dp, inf);
		dp[0] = 0;
		for (int i=0; i<customers.length; i++) {
			for (int j = customers[i]; j < dp.length; j++) {
				dp[j] = Math.min(dp[j], dp[j - customers[i]] + cost[i]);
			}
		}

		int ans = dp[minCustomers];
		for (int i = minCustomers; i<dp.length; i++) {
			ans = Math.min(dp[i], ans);
		}

		return ans;
	}

	public static void main(String[] args) {
		Hotel temp = new Hotel();
	}
}
