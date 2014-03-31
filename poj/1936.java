import java.util.*;
import java.math.*;
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

public class Main {

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	public void solve() throws Exception {
		while(in.hasNext()) {
			char[] str1 = in.next().trim().toCharArray();
			char[] str2 = in.next().trim().toCharArray();

			int ptr1 = 0;
			int ptr2 = 0;
			while(ptr1 < str1.length && ptr2 < str2.length) {
				if(str1[ptr1] == str2[ptr2]) {
					ptr1 ++;
					ptr2 ++;
				} else {
					ptr2 ++;
				}
			}

			if(ptr1 == str1.length) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

	public Main() {
		this.in = new Scanner(System.in);
		this.out = new PrintWriter(System.out);
	}

	public void end() {
		try {
			this.out.flush();
			this.out.close();
			this.in.close();
		} catch (Exception e){
			//do nothing then :)
		}
	}

	public static void main(String[] args) throws Exception {
		Main solver = new Main();
		solver.solve();
		solver.end();
	}
}
