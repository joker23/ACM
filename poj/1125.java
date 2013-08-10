import java.util.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num,con,a,w;
		while(true){
			num = in.nextInt();
			if(num==0) break;
			int[][] graph = new int[num][num];
			for(int i=0;i<graph.length;i++) Arrays.fill(graph[i], INF);
			for(int i=0;i<graph.length;i++){
				con = in.nextInt();
				for(int j=0;j<con;j++)
					graph[i][in.nextInt()-1] = in.nextInt();
			}
			for (int k = 0;k<graph.length; k++)
				for (int i = 0; i < graph.length; i++)
					if (graph[i][k] != Integer.MAX_VALUE)
						for ( int j = 0; j < graph.length; j++ )
					 	if ( graph[k][j] != Integer.MAX_VALUE)
					 		graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j] );
			int min=INF, tot,tempmax, max = -INF,ret=0;;
			boolean flag =false,done = false;
			for(int i=0;i<num;i++){
				tot = 0;tempmax = -INF; flag = true;
				for(int j=0;j<num;j++){
					if(j!=i){
						tot+=graph[i][j];
						tempmax = Math.max(tempmax,graph[i][j]);
						if(graph[i][j] == INF) {
							flag =false;
							break;
						}
					} 
				} if(flag&&tot<min){
					min = tot;
					ret = i+1;
					max = tempmax;
					done =true;
				}
			}
			if(done) System.out.println(ret + " " +max);
			else System.out.println("disjoint");
		}
	}
}
