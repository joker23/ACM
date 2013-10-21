
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader in;
	static StringTokenizer st;
	static Point[] a;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		a = new Point[n];
		for(int i=0; i<a.length;i++){
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[i] = new Point(x,y);
		}
		Point[] ans = convexHull();
		double ret = 0.0;
		for(int i = 1; i<ans.length; i++){
			ret+=distu(ans[i-1], ans[i]);
		}ret += distu(ans[0],ans[ans.length-1]);
		System.out.println(Math.round(ret));
	}

	

	//prints out the reprentations of the state
	public static void print(Object[] arr){
		for(Object o: arr){
			System.out.print("["+o+"]");
		}System.out.println();
	}

	public static void print(int arr[][]){
		for(int i=0; i<arr.length; i++){
			for(int j =0; j<arr.length; j++){
				System.out.print("["+arr[i][j]+"]");
			}System.out.println();
		}System.out.println();
	}


	private static double distu(Point a, Point b){
		return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
	}

	private static class Point{
		int x,y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}

		public String toString(){
			return "["+x+":"+y+"]";
		}
	}

	private static Comparator<Point> cmp = new Comparator<Point>(){
		public int compare(Point p, Point q){
			double tp = Math.atan2(p.y-a[0].y, p.x-a[0].x);
			double tq = Math.atan2(q.y-a[0].y, q.x-a[0].x);

			if(tp < tq)
				return -1;
			else if(tp > tq)
				return 1;

			double dp = dist(p, a[0]);
			double dq = dist(q, a[0]);

			if(dp > dq)
				return -1;
			else if(dp < dq)
				return 1;
			return 0;
		}
	};

	private static Point[] convexHull(){
		int cur = 0;
		int n = a.length;
		
		for(int i=1;i < n;i++)
			if(a[i].y < a[cur].y || (a[i].y == a[cur].y && a[i].x < a[cur].x))
				cur = i;

		Point tmp = a[cur];
		a[cur] = a[0];
		a[0] = tmp;
		Arrays.sort(a, 1, n, cmp);

		Stack<Point> s = new Stack<Point>();
		s.push(a[0]);
		s.push(a[1]);

		for(int i=2;i < n;i++){
			while(cp(s.elementAt(s.size()-2), s.peek(), a[i]) < 0)
				s.pop();

			if(cp(s.elementAt(s.size()-2), s.peek(), a[i]) > 0)
				s.push(a[i]);
		}

		Point[] h = new Point[s.size()];
		for(int i=0;i < h.length;i++)
			h[i] = s.pop();
		return h;

	}


	public static double dist(Point p, Point q){
		return Math.hypot(p.x - q.x, p.y - q.y);
	}

	public static double cp(Point p, Point q, Point r)
	{
		double pqx = q.x - p.x;
		double pqy = q.y - p.y;
		double qrx = r.x - q.x;
		double qry = r.y - q.y;

		return pqx*qry - pqy*qrx;
	}

}
