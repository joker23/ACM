import java.util.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(), r = in.nextInt();
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		HashMap<Integer, List<Node>> adjList = new HashMap<Integer,List<Node>>();
		int[][] dist = new int[2][n+1];
		for(int i=0;i<2;i++) Arrays.fill(dist[i], INF);
		boolean[] visit1 = new boolean[n+1];
		boolean[] visit2 = new boolean[n+1];
		dist[0][1] = 0;

		while(r-->0){
			int a = in.nextInt(),b = in.nextInt(),c =  in.nextInt();
			if(!adjList.containsKey(a)) adjList.put(a,new LinkedList<Node>());
			if(!adjList.containsKey(b)) adjList.put(b, new LinkedList<Node>());
			adjList.get(a).add(new Node(b,c));
			adjList.get(b).add(new Node(a,c));
		}
		pq.add(new Node(1,0));
		Node curr; int weight;
		while(!pq.isEmpty()&&!visit2[n]){
			curr = pq.poll();
			if(visit2[curr.a]) continue;
			for(Node next: adjList.get(curr.a)){
				weight = next.w+curr.w;
				if(dist[0][next.a]>weight){
					dist[1][next.a] = dist[0][next.a];
					dist[0][next.a] = weight;
				} else{
					dist[1][next.a] = Math.min(dist[1][next.a], weight);
				}
				if(!visit1[curr.a]) pq.add(new Node(next.a,weight));
			}if(!visit1[curr.a]) visit1[curr.a] = true;
			else visit2[curr.a] = true;
		}System.out.println(dist[1][n]);

	}

	public static class Node implements Comparable<Node>{
		Integer a,w;
		public Node(int a, int w){
			this.a = a;
			this.w = w;
		}
		public int compareTo(Node n){
			return w.compareTo(n.w);
		}
	}
}
