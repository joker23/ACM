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

	public void solve() throws Exception {
		int n = parseInt(in.readLine().trim());
		List<Integer> arr = new ArrayList<Integer>();
		int count[] = new int[5001];

		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++){
			int num = parseInt(st.nextToken());
			if(count[num] == 0){
				arr.add(num);
			}
			count[num] ++;
		}

		sort(arr);

		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<arr.size(); i++){
			list.add(arr.get(i));
			count[arr.get(i)] --;
		}

		for(int i=arr.size() - 2; i>=0; i--){
			if(count[arr.get(i)] > 0) {
				list.add(arr.get(i));
			}
		}
		String res = "";
		for(int i = list.size() - 1; i>= 0; i--){
			res += list.get(i) + " ";
		}
		out.println(list.size());
		out.println(res.trim());
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
