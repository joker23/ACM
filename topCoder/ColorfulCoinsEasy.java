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

public class ColorfulCoinsEasy {
	public String isPossible(int[] values) {
		int n = values.length;
		int[] lim = new int[n - 1];

		for (int i=0; i<n-1; i++) {
			lim[i] = values[i+1] / values[i];
		}

		Arrays.sort(lim);

		for (int i=0; i<lim.length && i<lim[i]; i++) {
			if (i + 1 >= lim[i]) {
				return "Impossible";
			}
		}

		return "Possible";
	}
}
