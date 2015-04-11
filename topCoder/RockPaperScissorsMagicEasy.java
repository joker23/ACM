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

public class RockPaperScissorsMagicEasy {
	public int count(int[] card, int score) {

		int k = card.length - score;

		if (k < 0) {
			return  0;
		}

		BigInteger n = calcCombinations(card.length, k);

		while (k-->0) {
			n = n.add(n);
		}

		return n.mod(new BigInteger("1000000007")).intValue();
	}

	private BigInteger calcCombinations (int n, int k) {
		BigInteger ret = BigInteger.ONE ;
		for (int i=n-k+1; i<=n; i++)
			ret = ret.multiply(BigInteger.valueOf(i));
		for ( int i=2; i<=k; i++)
			ret = ret.divide(BigInteger.valueOf(i));
		return ret ;
	}
}
