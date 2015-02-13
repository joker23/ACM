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

public class BikeRiding {
	private String[] paths;
	private int[] startPoints;
	private int endPoint;
	private int n;
	private int[] dp;
	private boolean[] hasCycle;
	private boolean[] vis;

	public int countRoutes(String[] paths, int[] startPoints, int endPoint, int n) {
		this.paths = paths;
		this.startPoints = startPoints;
		this.endPoint = endPoint;
		this.n = n;
		this.hasCycle = new boolean[paths.length];
		this.vis = new boolean[paths.length];
		this.dp = new int[paths.length];

		Arrays.fill(this.dp, -1);

		long ans = 0;
		for (int u : startPoints) {
			Arrays.fill(this.vis, false);

			ans += dfs(u);

			if (ans > n || ans < 0) {
				return -1;
			}
		}

		for (int u = 0; u < dp.length; u++) {
			if (dp[u] > 0 && hasCycle[u]) {
				return -1;
			}
		}

		return (int) ans;
	}

	private int dfs(int u) {
		if (dp[u] != -1) {
			return dp[u];
		}

		vis[u] = true;

		int res = 0;

		if (u == endPoint) {
			res = 1;
		}

		for (int v = 0; v < dp.length; v++) {
			if (paths[u].charAt(v) == '1') {
				if (vis[v]) {
					hasCycle[v] = true;
				} else {
					res += dfs(v);
				}
			}
		}

		dp[u] = res;
		vis[u] = false;
		return res;
	}

	public static void main(String[] args) {
		BikeRiding temp = new BikeRiding();
	}
}
