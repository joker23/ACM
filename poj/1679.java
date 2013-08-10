import java.util.*;
public class Main {
	/** conditions:
	 * 	at most one edge between two nodes
	 * 	represented in a adjacency matrix
	 */
	static String notUnique = "Not Unique!";
	static int inf = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt(); int[][] graph; 
		HashMap<Integer,Integer> visited;
		HashSet<Integer> visited2;
		PriorityQueue<Node> pq;
		while(test-->0){
			int n = in.nextInt(), e = in.nextInt(),a,b,c;
			graph = new int[n][n];
			visited = new HashMap<Integer,Integer>();
			visited2 = new HashSet<Integer>();
			pq = new PriorityQueue<Node>();
			for(int i=0;i<graph.length;i++) Arrays.fill(graph[i], inf);
			while(e-->0){
				a = in.nextInt()-1;
				b = in.nextInt()-1;
				c = in.nextInt();
				graph[a][b] = graph[b][a] = c;
			} int mini,i;
			for(i=0,mini=Integer.MAX_VALUE;i<graph.length;i++){
				mini = Math.min(mini,graph[0][i]);
			} pq.add(new Node(1,mini)); // takes in account if start node cycles
			Node curr; int ret = 0;
			boolean flag = false;
			while(!pq.isEmpty()){
				curr = pq.poll(); 
				if(visited.containsKey(curr.a)|| visited2.contains(curr.a)){
					if(curr.w == visited.get(curr.a)){
						flag = true;
						break;
					}
				} else{
					visited2.add(curr.a);
					visited.put(curr.a, curr.w);
					ret+=curr.w;
					for(i=0;i<graph.length;i++){
						if(graph[curr.a-1][i]!=inf&&!visited2.contains(i+1))
							pq.add(new Node(i+1,graph[curr.a-1][i]));
					}
				}
			} if(flag) System.out.println(notUnique);
			else System.out.println(ret-mini);
		}
	}
	public static class Node implements Comparable<Node>{
		Integer a,w;
		public Node(int a, int w){
			this.a = a;
			this.w = w;
		}
		public int compareTo(Node o) {
			return w.compareTo(o.w);
		}
	}
}
