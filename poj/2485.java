import java.util.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		DSet set;
		PriorityQueue<Edge> pq;
		int t = in.nextInt(),num;
		while(t-->0){
			num = in.nextInt();
			set = new DSet(num);
			pq = new PriorityQueue<Edge>();
			for(int i = 0;i<num;i++){
				for(int j=0;j<num;j++){
					int temp = in.nextInt();
					if(i!=j) pq.add(new Edge(i,j,temp));
				}
			} int counter = 0,ret = -INF; 
			Edge curr;
			while(!pq.isEmpty()&&counter<num-1){
				curr = pq.poll();
				if(!set.sameSet(curr.a, curr.b)){
					ret = Math.max(ret, curr.w);
					set.union(curr.a, curr.b);
					counter++;
				}
			} System.out.println(ret);
		}
	}
	
	private static class Edge implements Comparable<Edge>{
		Integer a,b,w;
		public Edge(int a, int b, int w){
			this.a = a;
			this.b = b;
			this.w = w;
		}
		public int compareTo(Edge e){
			return w.compareTo(e.w);
		}
	}
	private static class DSet{
		int[] set;
		public DSet(int i){
			set = new int[i];
			for(int j=0;j<i;j++) set[j] = j;
		}
		public int find(int x){
			if(set[x] == x) return x;
			set[x] = find(set[x]);
			return set[x];
		}
		public void union(int x, int y){
			set[find(x)] = find(y);
		}
		public boolean sameSet(int x, int y){
			return find(x) == find(y);
		}
	}
}
