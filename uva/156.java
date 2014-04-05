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

	private HashMap<String, List<String>> map;
	public void solve() throws Exception {
		String str;

		map = new HashMap<String,List<String>>();
		while(!(str = in.next()).equals("#")) {
			char[] tmp = str.toUpperCase().toCharArray();

			sort(tmp);

			//reconstruct string
			String key = "";
			for(int i=0; i<tmp.length; i++) {
				key += tmp[i];
			}

			if(!map.containsKey(key)) {
				map.put(key, new LinkedList<String>());
			}

			map.get(key).add(str);
		}

		LinkedList<String> ans = new LinkedList<String>();

		for(String k : map.keySet()) {
			if(map.get(k).size() == 1) {
				ans.add(map.get(k).get(0));
			}
		}

		sort(ans);

		while(!ans.isEmpty()) {
			out.println(ans.poll());
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
