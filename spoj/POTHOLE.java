import java.util.*;
public class Main {
	public static final int INF = 1000;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt(),graph[][],source,sink,n,m,c;
		while(test-->0){
			n = in.nextInt();
			source = 0;
			sink = n-1;
			graph = new int[n][n];
			for(int i = 0;i<graph.length-1;i++){
				m = in.nextInt();
				while(m-->0){
					c = in.nextInt()-1;
					if(i==source||c==sink) graph[i][c] = 1;
					else graph[i][c] = INF; 
				}
			} LinkedList<Integer> q;
			int ret = 0;
			int[] prev = new int[graph.length];
			while(true){ 
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
					}if(prev[sink] == -1) break;
				int minCut = INF;
				for(int v = sink, u = prev[v]; u!=-1; v = u, u = prev[v])
						minCut = Math.min(minCut, graph[u][v]);
				for(int v = sink, u = prev[v]; u!=-1; v = u, u = prev[v]){
						graph[u][v] -= minCut;
						graph[v][u] += minCut;
				}ret += minCut;
			}
			System.out.println(ret);
		}
	}
}
