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

public class WakingUpEasy {
	public int countAlarms(int[] volume, int S) {
		int ans = 0;

		while (S > 0) {
			S -= volume[ans%volume.length];
			ans ++;
		}

		return ans;
	}
}
