import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;
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

	private DecimalFormat fmt = new DecimalFormat("0.000");

	public void solve() throws Exception {
		int n;
		int count = 1;
		while((n = in.nextInt()) > 0) {

			out.println("Scenario #" + (count++));
			Point[] nodes = new Point[n];
			for(int i=0; i<n; i++) {
				nodes[i] = new Point(in.nextInt(), in.nextInt());
			}

			double[][] graph = new double[n][n];

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					graph[i][j] = dist(nodes[i], nodes[j]);
				}
			}

			for(int k=0; k<n; k++) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						graph[i][j] = min(graph[i][j], max(graph[i][k], graph[k][j]));
					}
				}
			}

			out.println("Frog Distance = " + fmt.format(graph[0][1]));
			out.println();
		}
	}

	private void print(double[][] graph) {
		for(int i=0; i<graph.length; i++) {
			for(int j=0; j<graph.length; j++) {
				System.out.print("[" + fmt.format(graph[i][j]) + "]");
			}System.out.println();
		}System.out.println();
	}

	private double dist(Point p1, Point p2) {
		return sqrt(pow((p1.x - p2.x), 2) + pow((p1.y - p2.y),2));
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
