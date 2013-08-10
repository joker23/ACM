import java.util.*;
import java.awt.*;
public class Main {
	static Point[] map; 
	static edge[] edgeList;
	static int ptr = 0;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),m = in.nextInt();
		map = new Point[n+1];
		int from = in.nextInt();
		edgeList = new edge[n];
		while(m-->1){
			int to = in.nextInt(), w = in.nextInt();
			addEdge(from, to,w, in.next().trim());	
			edgeList[ptr++] = new edge(to,from);
			from = in.nextInt();
		} while(from-->0){
			int f1 = in.nextInt(), f2 = in.nextInt(), i = in.nextInt();
			dset set = new dset(n);
			for(int j = 0;j<i;j++){
				set.merge(edgeList[j].i, edgeList[j].j);
			}if(set.sameSet(f1, f2)){
				System.out.println(dist(map[f1],map[f2]));
			}else{
				System.out.println(-1);
			}
		}
	}
	public static int dist(Point f1, Point f2){
		return Math.abs(f1.x-f2.x)+Math.abs(f1.y-f2.y);
	}
	
	public static class edge{
		int i, j;
		public edge(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	public static class dset{
		int[] set;
		public dset(int size){
			set = new int[size+1];
		}
		public int find(int x){
			if(x==set[x]) return x;
			set[x] = find(set[x]);
			return set[x];
		}
		public void merge(int i, int j){
			set[i] = find(j);
		}
		public boolean sameSet(int i,int j){
			return set[i]==set[j];
		}
	}
	public static void addEdge(int from, int to, int w, String dir){
		Point temp = map[from];
		if(dir.equals("N")){
			temp.y+=w;
		}else if(dir.equals("E")){
			temp.x+=w;
		}else if(dir.equals("S")){
			temp.y-=w;
		}else{ // dir.equals("W")
			temp.x-=w;
		}map[to] = temp;
	}
}
