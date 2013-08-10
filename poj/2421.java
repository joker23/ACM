import java.util.*;

//prim's
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		HashSet<Integer> visited = new HashSet<Integer>();
		int n = in.nextInt();
		int[][] am = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++){
				am[i][j] = in.nextInt();
				if(i==j) am[i][j] = Integer.MAX_VALUE;
			}
		n = in.nextInt();
		int a,b;
		while(n-->0){
			a = in.nextInt()-1;
			b = in.nextInt()-1;
			am[a][b] = 0;
			am[b][a] = 0;
		}  int ret = 0; pq.add(new Node(0,0)); Node curr;
		while(!pq.isEmpty()){
			curr = pq.poll();
			if(visited.contains(curr.a)) continue;
			ret+=curr.w;
			visited.add(curr.a);
			for(int i=0; i<am.length;i++){
				pq.add(new Node(i,am[curr.a][i]));
			}
		} System.out.println(ret);
	}
	private static class Node implements Comparable<Node>{
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
