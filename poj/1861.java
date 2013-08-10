import java.util.*;
public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		LinkedList<Edge> list = new LinkedList<Edge>();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		int n = in.nextInt(), m = in.nextInt(),num=0,max=Integer.MIN_VALUE;
		DisjointSet set = new DisjointSet(n);
		for(int i=0;i<m;i++){
			pq.add(new Edge(in.nextInt(),in.nextInt(),in.nextInt()));
		}Edge curr;
		while(!pq.isEmpty()&&m>0){
			curr = pq.poll();
			if(set.find(curr.a)!=set.find(curr.b)){
				set.merge(curr.a,curr.b);
				list.add(curr);
				num++;
				max = Math.max(max,curr.w);
				m--;
			} 
		} 
		System.out.println(max);
		System.out.println(num);
		while(!list.isEmpty())
			System.out.println(list.poll().toString());
	}
	
	
	public static class DisjointSet{
		int[] set;
		public DisjointSet(int n){
			set = new int[n+1];
			for(int i=0;i<set.length;i++) set[i] = i;
		}
		
		public int find(int n){
			if(set[n] == n) return n;
			return set[n] = find(set[n]);
		}
		
		public void merge(int a, int b){
			set[find(a)] = find(b);
		}
	}
	
	
	public static class Edge implements Comparable<Edge>{
		Integer a,b,w;
		public Edge(int a, int b, int w){
			this.a = a;
			this.b = b;
			this.w = w;
		}
		public int compareTo(Edge e){
			return w.compareTo(e.w);
		}
		public String toString(){
			return a+" "+b;
		}
	}
}
