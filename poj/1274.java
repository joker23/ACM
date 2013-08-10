import java.util.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args){
		while(in.hasNextInt()){
			int N = in.nextInt(),M = in.nextInt();
			int[][] graph = new int[N+M+2][N+M+2];
			int offset = N+1;
			for(int i=0;i<N;i++){
				graph[0][i+1] = 1;
			} for(int i=0;i<M;i++){
				graph[N+1+i][graph.length-1] = 1;
			} int num,b;
			for(int i=1;i<=N;i++){
				num = in.nextInt();
				for(int j=0;j<num;j++){
					graph[i][N+in.nextInt()] = 1;
				}
			} int source = 0, sink = graph.length-1;
			LinkedList<Integer> q;
			int ret = 0;
			int[] prev = new int[graph.length];
			while(true){ //running BFS
				q = new LinkedList<Integer>();
				Arrays.fill(prev, -1);
				q.add(source);
				while(!q.isEmpty() && prev[sink] == -1){
					int u = q.pop();
					for(int v=0;v<graph.length;v++){
						if(v!=source&&prev[v]==-1&&graph[u][v]>0){
							prev[v] = u;
							q.push(v);
						}
					}
				}if(prev[sink] == -1) break; // no more connections
				int minCut = INF;
				for(int v = sink, u = prev[v]; u!=-1; v = u, u = prev[v])
						minCut = Math.min(minCut, graph[u][v]);
				for(int v = sink, u = prev[v]; u!=-1; v = u, u = prev[v]){
						graph[u][v] -= minCut;
						graph[v][u] += minCut;
				}ret += minCut;
			} System.out.println(ret);
		}
	}
}
