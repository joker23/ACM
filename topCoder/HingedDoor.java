import java.util.*;
import java.math.*;

public class HingedDoor {
	public int numSwings(int initialAngle, int reduction) {
		double n = (double) initialAngle;
		int ans = 0;

		while (n > 5) {
			ans ++;
			n /= reduction;
		}

		return ans;
	}

	public static void main(String[] args) {
		HingedDoor temp = new HingedDoor();
	}
}
