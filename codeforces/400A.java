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

	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;

	int t;
	char[] str;
	char[][] board;
	int[] div = {1, 2, 3, 4, 6, 12};

	public void solve() throws Exception {
		t = Integer.parseInt(in.readLine().trim());
		while(t --> 0) {
			LinkedList<String> res = new LinkedList<String>();
			str = in.readLine().trim().toCharArray();
			for(int i=0; i<div.length; i++) {
				for(int j=0; j<12/div[i]; j++){
					char match = str[j];
					boolean found = match == 'X';
					for(int k=j;k<str.length; k+=12/div[i]){
						if(str[k] != match){
							found = false;
							break;
						}
					}

					if(found){
						res.add(div[i] + "x" + (12 / div[i]));
						break;
					}
				}
			}
			out.print(res.size());
			for(String s: res) {
				out.print(" " + s);
			} out.println();
		}
	}

	public Main() {
		this.in = new BufferedReader(new InputStreamReader(System.in));
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
