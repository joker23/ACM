import java.util.*;

public class Main{
	static Scanner in;
	static int large;
	public static void main(String[] args){
		in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			int d = in.nextInt();
			int n = in.nextInt();
			int e = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			int[][] graph = new int[n][n];
			while(e-->0){
				graph[in.nextInt()][in.nextInt()] = in.nextInt();
			}
			large = 0;
			int top = maxflow(graph, a, b);
			double ret =(double)(Math.round(((double)top/large)*1000.0)/1000.0);
			System.out.println(d+ " " + ret);
		}
	}

	
	public static int maxflow(int[][] graph, int source, int sink){
		int[] prev =  new int[graph.length];
		LinkedList<Integer> q;
		int ans = 0;
		for(;;){
			Arrays.fill(prev, -1);
			q = new LinkedList<Integer>();
			q.push(source);
			while(!q.isEmpty() && prev[sink] == -1){
				int u = q.poll();
				for(int v=0;v<prev.length;v++){
					if(v!=source && prev[v] == -1 && graph[u][v] > 0){
						prev[v] = u;
						q.push(v);
					}
				}
			}
			if(prev[sink] == -1){
				break;
			}
			int mincut = Integer.MAX_VALUE;
			for(int v = sink, u = prev[v]; u!= -1; v =u , u =prev[v]){
				mincut = Math.min(mincut, graph[u][v]);
			}
			large = Math.max(large, mincut);
			
			for(int v= sink, u = prev[v];u!=-1;v = u, u = prev[v]){
				graph[u][v] -= mincut;
				graph[v][u] += mincut;
			} ans += mincut;
		} return ans;
	}
}
