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

public class DivideByZero {
	public int CountNumbers(int[] numbers) {
		boolean[] count = new boolean[101];
		count[0] = true;

		for (int i : numbers) {
			count[i] = true;
		}

		for (int k = 0; k < 100; k++) {
			for (int i=100; i > 0; i--) {
				for (int j = i - 1; j > 0; j--) {
					if (count[i] && count[j]) {
						count[i / j] = true;
					}
				}
			}
		}

		int ans = 0;

		for (int i = 1; i<101; i++) {
			if (count[i]) ans ++;
		}

		return ans;
	}

	public static void main(String[] args) {
		DivideByZero temp = new DivideByZero();
	}
}
