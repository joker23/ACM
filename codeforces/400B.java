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

	private char[][] board;
	private int[] dist;
	private int n, m;

	public void solve() throws Exception {
		st = new StringTokenizer(in.readLine());
		n = parseInt(st.nextToken());
		m = parseInt(st.nextToken());

		board = new char[n][m];
		dist = new int[n];
		for(int i=0; i< n; i++){
			char[] tmp = in.readLine().trim().toCharArray();
			for(int j=0; j<m; j++){
				board[i][j] = tmp[j];
			}
		}

		for(int i=0; i< n; i++){
			int g =0 ;
			int s = 0;
			for(int j = 0; j<m; j ++ ){
				if(board[i][j] == 'G'){
					g = j;
				}

				if(board[i][j] == 'S'){
					s = j;
				}
			}

			dist[i] = s - g;
		}

		boolean possible = true;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i< n; i++){
			if(dist[i] <= 0 ){
				possible = false;
				break;
			}
			set.add(dist[i]);
		}


		if(possible) {
			out.println(set.size());
		} else {
			out.println(-1);
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
