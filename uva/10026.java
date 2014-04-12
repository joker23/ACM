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

	// uva 10026

	private Scanner in;
	private StringTokenizer st;
	private PrintWriter out;

	public void solve() throws Exception {
		int t = in.nextInt();
		while(t --> 0) {
			int n = in.nextInt();
			Job[] jobs = new Job[n];
			for(int i=0; i<n; i++) {
				jobs[i] = new Job(in.nextInt(), in.nextInt(), i+1);
			}

			sort(jobs);

			out.print(jobs[0]);

			for(int i=1; i<jobs.length; i++) {
				out.print(" " + jobs[i]);
			} out.println();
			if(t > 0) {
				out.println();
			}
		}
	}

	private class Job implements Comparable<Job> {

		int time, cost, index;
		public Job(int time, int cost, int index) {
			this.time = time;
			this.cost = cost;
			this.index = index;
		}

		public int compareTo(Job j) {
			Double j1 = ((double) this.cost) / this.time;
			Double j2 = ((double) j.cost) / j.time;

			if(j2.compareTo(j1) != 0) {
				return j2.compareTo(j1);
			} else {
				return this.index - j.index;
			}
		}

		public String toString() {
			return this.index + "";
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
