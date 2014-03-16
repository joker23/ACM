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
		st = new StringTokenizer(in.readLine());
		int k = parseInt(st.nextToken());
		int a = parseInt(st.nextToken());
		int b = parseInt(st.nextToken());
		int v = parseInt(st.nextToken());

		int numFull = (b/(k - 1 ));
		int numLeft = (b%(k - 1));
		int[] boxes = new int[a + 1];
		Arrays.fill(boxes, 1);
		int i;
		int d;
		for(i=0; i<numFull && i<boxes.length; i++){
			boxes[i] = k;
		}
		if(i<boxes.length)
			boxes[i] = numLeft + 1;
		for(i=0; i<boxes.length; i++){
			boxes[i] *= v;
		}
		int ans = 0;
		int ptr = 0;
		while(a > 0) {
			ans ++;
			a -= boxes[ptr++];
		}

		System.out.println(ans);
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
