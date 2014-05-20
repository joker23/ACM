import java.util.*;
import java.math.*;
import java.text.*;

import static java.lang.Math.*;
import static java.lang.Integer.*;

public class FibonacciDiv2 {
    private int res;
    public int find(int N) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(1);
		list.add(2);

		int a = 1;
		int b = 1;
		int c = 0;

		while(c <= 1000000) {
			c = a + b;
			b = a;
			a = c;
			list.add(c);
		}

		res = 1000001;
		for(int i : list) {
			res = Math.min(res, abs(N - i));
		}

        return res;
    }

}
