import java.util.*;
import java.math.*;
import java.text.*;

import static java.lang.Math.*;
import static java.lang.Integer.*;

public class BoxesDiv2 {
    private int res;
    public int findSize(int[] candyCounts) {

		int a = 0;
		for (int i : candyCounts) {
			if (hasMoreThanOne(i)) {
				a += mostSig(i);
			} else {
				a += i;
			}
		}

        if(hasMoreThanOne(a)) {
			return mostSig(a);
		} else {
			return a;
		}
    }

	private boolean hasMoreThanOne(int c) {
		return c - (c & -c) != 0;
	}

	private int mostSig(int c) {
		return (1 << (int)Math.floor(Math.log(c)/Math.log(2)) + 1);
	}

}
