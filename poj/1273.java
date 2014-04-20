import java.util.*;
public class Main {
	final static int INF = Integer.MAX_VALUE;
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args){
		LinkedList<Integer> q;
		while(in.hasNextInt()){
			int M = in.nextInt(), N = in.nextInt();
			int[][] graph  = new int[N][N];
			int[] prev = new int[N];
			int source = 0, sink = N-1, ret=0;
			while(M-->0)
				graph[in.nextInt()-1][in.nextInt()-1] += in.nextInt();
			while(true){ //running BFS
				q = new LinkedList<Integer>();
				Arrays.fill(prev, -1);
				q.add(source);
				while(!q.isEmpty() && prev[sink] == -1){
					int u = q.pop();
					for(int v=0;v<N;v++){
						if(v!=source&&prev[v]==-1&&graph[u][v]>0){
							prev[v] = u;
							q.push(v);
						}
					}
				}
				if(prev[sink] == -1)
					break; // no more connections
				int minCut = INF;
				for(int v = sink, u = prev[v]; u!=-1; v = u, u = prev[v])
					minCut = Math.min(minCut, graph[u][v]);
				for(int v = sink, u = prev[v]; u!=-1; v = u, u = prev[v]){
					graph[u][v] -= minCut;
					graph[v][u] += minCut;
				}
				ret += minCut;
			}System.out.println(ret);
		}
	}
}
