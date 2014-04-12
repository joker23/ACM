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
		int count = 0;
		String ans;
		while(in.hasNextLine()) {
			ans = "";
			char[] line = in.nextLine().toCharArray();
			for(int i=0; i<line.length; i++) {
				if(line[i] == '"') {
					if(count%2 == 0) {
						ans += "``";
					} else {
						ans += "''";
					}

					count ++;
				} else {
					ans += line[i];
				}
			}

			out.println(ans);
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
