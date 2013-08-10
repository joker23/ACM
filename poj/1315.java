import java.util.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n,source,sink,graph[][],prev[],ret,u,v,mincut;
		String cin;
		LinkedList<Integer> q;
		while((n = in.nextInt()) > 0){
			graph = new int[n+n+2][n+n+2];
			for(int i=1;i<=n;i++){
				graph[0][i] = graph[i+n][graph.length-1] = 1;
			}for(int i =1;i<=n;i++){
				cin = in.next();
				for(int j=0;j<cin.length();j++){
					if(cin.charAt(j)=='.') graph[i][n+j+1] = 1;
					else graph[0][i] = ++graph[n+j+1][graph.length-1];
				}
			} source = ret = 0;
			sink = graph.length-1;
			prev = new int[n+n+2];
			for(;;){
				q = new LinkedList<Integer>();
				Arrays.fill(prev, -1);
				q.add(source);
				while(!q.isEmpty()&&prev[sink]==-1){
					u = q.pop();
					for(v=0;v<graph.length;v++){
						if(v!=source&&prev[v]==-1&&graph[u][v]>0){
							prev[v] = u;
							q.push(v);
						}
					}
				}if(prev[sink]==-1) break;
				mincut = INF;
				for(v=sink,u=prev[v];u!=-1;v=u,u=prev[v])
					mincut = Math.min(mincut, graph[u][v]);
				for(v=sink,u=prev[v];u!=-1;v=u,u=prev[v]){
					graph[u][v]-=mincut;
					graph[v][u]+=mincut;
				}ret+=mincut;
			}System.out.println(ret);
		}
	}
	private static void print(int[][] arr){
		for(int i=0;i<arr.length;i++){
				for(int j=0;j<arr[i].length;j++){
					System.out.print("["+arr[i][j]+"]");
				}System.out.println();
		}System.out.println();
	}
}
