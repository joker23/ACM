import java.util.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N;
		boolean[] visited;
		int[][] graph;
		HashMap<Integer,List<Node>> adj;
		PriorityQueue<Node> pq;
		while(in.hasNextInt()){
			N = in.nextInt();
			graph = new int[N][N];
			pq = new PriorityQueue<Node>();
			visited = new boolean[N];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++){
					graph[i][j] = in.nextInt();
				}
			adj = new HashMap<Integer,List<Node>>();
			for(int i=0;i<graph.length;i++){
				for(int j=0;j<graph.length;j++){
					if(graph[i][j]>0){
						if(!adj.containsKey(i)) adj.put(i, new LinkedList<Node>());
						adj.get(i).add(new Node(j,graph[i][j]));
					}
				}
			}
			int ret=0;
			Node curr;
			pq.add(new Node(1,0));
			while(!pq.isEmpty()){
				curr = pq.poll();
				if(visited[curr.a]) continue;
				visited[curr.a] = true;
				for(Node n:adj.get(curr.a)){
					if(!visited[n.a]){
						pq.add(n);
					}
				}ret+=curr.w;
			}System.out.println(ret);
		}
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

