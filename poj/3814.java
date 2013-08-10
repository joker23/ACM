import java.util.*;
import java.io.*;
public class Main {
	static Scanner in = new Scanner(System.in);
	static final int INF = Integer.MAX_VALUE,DAY = 48,MAXMIN=1440;
	public static void main(String[] args) throws NumberFormatException, IOException{
		int N,K,M;
		StringTokenizer st;
		while((N=in.nextInt())>0){
			if(N==0) break;
			int[][] graph = new int[2+DAY+N][2+DAY+N];
			boolean ar[] = new boolean[MAXMIN];
			if(N==0) break;
			for(int i = 0; i < N; i++){
				K = in.nextInt();
				graph[DAY][DAY+2+i] = in.nextInt()/30;
				Arrays.fill(ar, false);
				for(int j = 0; j < K; j++){
					String start = in.next();
					String end = in.next();
					int s = Integer.parseInt(start.substring(0,2))*60 + Integer.parseInt(start.substring(3,5));
					int e = Integer.parseInt(end.substring(0,2))*60 + Integer.parseInt(end.substring(3,5));
					if(s == e)
						Arrays.fill(ar, true);
					else if(s > e){
						for(int k = s; k < MAXMIN; k++)
							ar[k] = true;
						for(int k = 0; k < e; k++)
							ar[k] = true;
					} else
						for(int k = s; k < e; k++)
							ar[k] = true;
				} for(int j = 0; j < DAY; j++){
					graph[DAY+2+i][j] = 1;
					for(int k = 0; k < 30; k++)
						if(!ar[30*j+k]){
							graph[DAY+2+i][j] = 0;
							break;
						}
				}	
			}
			int source = 48, sink = 49;
			int i;
			for(i=1;i<=N+1;i++){
				for(int k=0;k<DAY;k++)
					graph[k][sink]++;
				LinkedList<Integer> q;
				int[] prev = new int[graph.length];
				boolean done = false;
				for(int j=0;j<DAY;j++){
					q = new LinkedList<Integer>();
					Arrays.fill(prev,-1);
					prev[source] = -2;
					q.add(source);
					while(!q.isEmpty()){
						int u = q.pop();
						if(u==sink) break;
						for(int v=0;v<graph.length;v++){
							if(prev[v]==-1&&graph[u][v]>0){
								q.add(v);
								prev[v] = u;
							}
						}
					}if(prev[sink]==-1) {
						done = true;
						break;
					}
					int curr = sink;
					while(prev[curr] >= 0){
						graph[curr][prev[curr]]++;
						graph[prev[curr]][curr]--;
						curr = prev[curr];
					}
				}if (done) break;
			}System.out.println(i-1);
		}
	}
}