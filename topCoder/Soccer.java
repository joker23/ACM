import java.util.*;
public class Soccer {
	public int maxPoints(int[] wins, int[] ties) {
		int ans = 0;

		for (int i=0; i<wins.length; i++) {
			int tmp = wins[i] * 3 + ties[i];
			ans = Math.max(ans, tmp);
		}

		return ans;
	}
}
