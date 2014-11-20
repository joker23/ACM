public class TaroGrid {
	public int getNumber(String[] grid) {
		int[][] bestLength = new int[grid.length][grid.length];

		int ans = 1;
		for (int i=1; i<grid.length; i++) {
			for(int j=0; j<grid.length; j++) {
				if (grid[i].charAt(j) == grid[i-1].charAt(j)) {
					bestLength[i][j] = bestLength[i-1][j] + 1;
					ans1 = Math.max(ans, bestLength[i][j] + 1);
				}
			}
		}

		return ans;
	}
}
