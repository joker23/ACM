import java.util.*;
public class Main {
	static int[][] graph;
	static int[] dp;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			if(n==0) break;
			int m = in.nextInt();
			graph = new int[n][n];
			boolean[] degree = new boolean[n];
			for(int i=0;i<graph.length;i++) {
				Arrays.fill(graph[i], Integer.MAX_VALUE);
				degree[i] = true;
			} int x,y,f,ret = 0;
			while(m-->0){
				x = in.nextInt()-1;
				y = in.nextInt()-1;
				f = in.nextInt();
				graph[x][y] = graph[y][x] = Math.min(f,graph[x][y]);
				degree[x] = !degree[x];
				degree[y] = !degree[y];
				ret+=f;
			}
			//floyd
		    for (int k = 0;k<graph.length; k++)  
		        for (int i = 0; i < graph.length; i++)  
		            if (graph[i][k] != Integer.MAX_VALUE)  
		                for ( int j = 0; j < graph.length; j++ )  
		                    if (graph[k][j] != Integer.MAX_VALUE)  
		                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j] );
		    int check = 0x00;
		    dp  =new int[1<<20+1];
		    for(int i =0;i<degree.length;i++){
		    	if(!degree[i]) check|=1<<i;
		    }
		    ret += bf(check);
		    System.out.println(ret);
		}
	}
	private static int bf(int index){
		   int i,j,k,best=Integer.MAX_VALUE;
		   if (index==0) return 0;
		   if (dp[index] != 0) return dp[index];
		   for (i=0;(index & (1<<i))==0;i++);
		   for (j=i+1;j<15;j++){
		      if (((index & (1<<j))==0)) continue;
		      k = bf(index - (1<<i) - (1<<j));
		      best = Math.min(best, graph[i][j] + k);
		   } return dp[index] = best;
	}
}
