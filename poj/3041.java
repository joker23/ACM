import java.util.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),k = in.nextInt(), r, c;
		int[][] graph = new int[2*n+2][2*n+2];
		int[] prev;
		LinkedList<Integer> q;
		for(int i=1;i<=n;i++){
			graph[0][i] = 1;
		} for(int i=n+1;i<graph.length-1;i++){
			graph[i][graph.length-1] = 1;
		}while(k-->0){
			r = in.nextInt();
			c = in.nextInt();
			graph[r][c+n] = 1;
		} int source = 0, sink = graph.length-1,ret=0;
		prev = new int[graph.length];
		for(;;){
			q = new LinkedList<Integer>();
			Arrays.fill(prev, -1);
			q.add(source);
			while(!q.isEmpty()&&prev[sink]==-1){
				int u = q.pop();
				for(int v = 0;v<graph.length;v++){
					if(v!=source&&prev[v]==-1&&graph[u][v]>0){
						prev[v] = u;
						q.push(v);
					}
				}
			} if(prev[sink]==-1) break;
			int mincut = INF;
			for(int v=sink,u=prev[v];u!=-1;v=u,u=prev[v])
				mincut = Math.min(mincut, graph[u][v]);
			for(int v=sink,u=prev[v];u!=-1;v=u,u=prev[v]){
				graph[u][v] -= mincut;
				graph[v][u] += mincut;
			}ret+=mincut;
		}System.out.println(ret);
	}
}
