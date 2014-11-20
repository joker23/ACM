public class RunningAroundPark {
	public int numberOfLap(int N, int[] d) {
		int ans = 1;
		for(int i = 1; i<d.length; i++) {
			if (d[i] <= d[i-1]) {
				ans ++;
			}
		}

		return ans;
	}
}
