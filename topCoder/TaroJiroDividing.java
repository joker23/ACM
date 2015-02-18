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

public class TaroJiroDividing {
	public int getNumber(int A, int B) {
		HashSet<Integer> a = new HashSet<Integer>();
		HashSet<Integer> b = new HashSet<Integer>();

		while (A%2 == 0) {
			a.add(A);
			A/=2;
		}

		a.add(A);

		while (B%2 == 0) {
			b.add(B);
			B/=2;
		}

		b.add(B);

		int ans = 0;
		for (int i : a) {
			if (b.contains(i)) {
				ans ++;
			}
		}

		return ans;
	}
}
