import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int c = in.nextInt(),n = in.nextInt(), m = in.nextInt(),s,d,l,t;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		HashMap<Integer,List<Node>> adj = new HashMap<Integer,List<Node>>();
		while(m-->0){
			s = in.nextInt();
			d = in.nextInt();
			l = in.nextInt();
			t = in.nextInt();
			if(!adj.containsKey(s)) adj.put(s, new LinkedList<Node>());
			adj.get(s).add(new Node(d,l,t));
		} pq.add(new Node(1,0,0)); Node curr = new Node(1,0,0);
		while(!pq.isEmpty()){
			curr = pq.poll();
			if(curr.a == n) break;
			for(Node next: adj.get(curr.a)){
				if(next.c+curr.c>c) continue;
				pq.add(new Node(next.a,next.w+curr.w,next.c+curr.c));
			} 
		} if(curr.a == n) System.out.println(curr.w);
		else System.out.println(-1);
	}
	
	private static class Node implements Comparable<Node>{
		Integer a, w, c;
		public Node(int a, int w, int c){
			this.a = a;
			this.w = w;
			this.c = c;
		}
		public int compareTo(Node n){
			return w.compareTo(n.w);
		}
	}
}
