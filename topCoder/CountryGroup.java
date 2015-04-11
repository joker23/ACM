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

public class CountryGroup {
	public int solve(int[] a) {
		int count = 1;

		int prev = a[0];
		int expected = a[0] - 1;
		for (int i=1; i<a.length; i++) {
			if (prev == a[i] && expected != 0) {
				expected --;
			} else if (expected == 0) {
				expected = a[i] - 1;
				prev = a[i];
				count ++;
			} else {
				return -1;
			}
		}

		if (expected != 0) {
			return -1;
		}
		return count;
	}
}
