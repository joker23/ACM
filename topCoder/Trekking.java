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

public class Trekking {
	public int findCamps(String trail, String[] plans) {
		char[] t = trail.toCharArray();
		int ans = -1;
		for (String str : plans) {
			int ptr = 0;
			char[] arr = str.toCharArray();

			boolean cando = true;
			int tmp = 0;
			for (char c : arr) {
				if (c == 'C') {
					if (t[ptr] == '^') {
						cando = false;
						break;
					} else {
						tmp ++;
					}
				}

				ptr ++;
			}

			if (cando) {
				if (ans == -1) {
					ans = tmp;
				} else {
					ans = Math.min(ans, tmp);
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Trekking temp = new Trekking();
	}
}
