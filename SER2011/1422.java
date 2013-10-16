import java.util.*;
// the idea behind this is that you are finding the number of sources
// in the DAG
public class Main{
	private static Scanner in;
	private static List<Integer>[] graph;
	private static boolean[] visited;
	private static List<Integer> sorted;
	
	public static void main(String[] args){
		in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			int v = in.nextInt();
			int e = in.nextInt();
			graph = new LinkedList[v+1];
			Arrays.fill(graph, new LinkedList<Integer>());
			visited = new boolean[v+1];
			for(int i=0; i<e; i++){
				graph[in.nextInt()].add(in.nextInt());	
			}
			sorted = new LinkedList<Integer>();
			
			for(int i=0; i<=v; i++){
				if(!visited[i]){
					dfs(i,true);
				}
			}
			int ans = 0;
			Arrays.fill(visited, false);
			for(int curr: sorted){
				if(!visited[curr]){
					ans++;
					dfs(curr,false);
				}
			}System.out.println(ans);
		}
	}
	

	private static void dfs(int curr, boolean keep){
		visited[curr] = true;
		for(int next : graph[curr]){
			if(!visited[next]){
				dfs(next,keep);
			}
		}

		if(keep){
			((LinkedList<Integer>)sorted).addFirst(curr);
		}
	}
}
