import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	//IO tools
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;

	//static variables
	static int n,m, dns[], dew[];
	static Point[] ns, ew;

	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		//code starts here
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		ns = new Point[n];
		dns = new int[n];
		ew = new Point[m];
		dew = new int[m];

		for(int i=0; i < n; i++){
			st = new StringTokenizer(in.readLine());
			ns[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for(int i = 0; i < m; i++){
			st = new StringTokenizer(in.readLine());
			ew[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(ns, new compns());
		Arrays.sort(ew, new compew());
		
		int ans = 0;
		for(int i=0; i<n ; i++){
			Point currns = ns[i];
			for(int j=0; j<m; j++){
				Point currew = ew[j];
				if(currew.y >= currns.y &&  currew.y <= currns.y + currns.l
						&& currns.x >= currew.x && currns.x <= currew.x + currew.l){ //if it is range
					int mindx = Math.min(currns.x - currew.x, currew.x + currew.l - currns.x);
					int mindy = Math.min(currew.y - currns.y, currns.y + currns.l - currew.y);
					int mind = Math.min(mindx, mindy);
					ans = Math.max(mind, ans);
				}
			}
		}

		out.println(ans);
		//code ends here
		out.flush();
	}

	public static class Point {
		int x,y,l;

		public Point(int x, int y, int l){
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}

	public static class compns implements Comparator<Point>{
		public int compare(Point a, Point b){
			return a.y - b.y;
		}
	}

	public static class compew implements Comparator<Point>{
		public int compare(Point a, Point b){
			return a.x - b.x;
		}
	}

	//helper functions
}
