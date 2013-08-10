import java.util.*;
public class Main {
	/**
	 * solution is A*
	 */
	static LinkedList<Node>[] graph;
	static int k,ans,start,t;
	static boolean found;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		graph = new LinkedList[n+1];
		for(int i=0;i<graph.length;i++){
			graph[i] = new LinkedList<Node>();
		} while(m-->0){
			graph[in.nextInt()].add(new Node(in.nextInt(),in.nextInt()));
		}start = in.nextInt();
		t = in.nextInt();
		k = in.nextInt();
		ans = -1;
		dijstras();
		System.out.println(ans);
	}
	public static void  dijstras(){
		int[] visited = new int[graph.length];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start,0));
		Node curr;
		while(!pq.isEmpty()){
			curr = pq.poll();
			visited[curr.id]++;
			if(visited[curr.id]>1000){
				break;
			}
			if(curr.id == t){
				if(--k==0){
					ans = curr.w;
					break;
				}
			}for(Node n: graph[curr.id]){
				pq.add(new Node(n.id,n.w+curr.w));
			}
		}
		
	}
	public static class Node implements Comparable<Node>{
		Integer id, w;
		public Node(int id,int w){
			this.id = id;
			this.w = w;
		}
		public int compareTo(Node n){
			return this.w.compareTo(n.w);
		}
	}
}
