import java.util.*;
public class Main {
	static final int maxNum = 100,INF =Integer.MAX_VALUE;
	static boolean found[];
    static int[][] graph, flow, cost;
    static int[] pre, dist, pi;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] hx,hy,mx,my;
		int n,m,hcount,mcount,source,sink,tmp;
		String curr;
		char c;
		for(;;){
			hx = new int[maxNum];
			hy = new int[maxNum];
			mx = new int[maxNum];
			my = new int[maxNum];
			hcount = mcount = 0;
			n = in.nextInt();
			m = in.nextInt();
			if(n+m == 0) break;
			for(int i=0;i<n;i++){
				curr = in.next();
				for(int j=0;j<m;j++){
					c = curr.charAt(j);
					if(c == 'H'){
						hx[hcount] = i;
						hy[hcount++] = j;
					} if(c == 'm'){
						mx[mcount] = i;
						my[mcount++] = j;
					}
				}
			} graph = new int[hcount+mcount+2][hcount+mcount+2];
			cost = new int[hcount+mcount+2][hcount+mcount+2];
			sink = graph.length-1;
			source = 0;
			for(int i =0;i<mcount;i++)
				for(int j=0;j<hcount;j++){
					tmp = Math.abs(mx[i]-hx[j])+Math.abs(my[i]-hy[j]);
					cost[i+1][j+mcount+1] = tmp;
				}
			for(int i=1;i<=hcount;i++){
				graph[0][i] = 1;
				graph[i+hcount][graph.length-1]=1;
			} for(int i=0;i<hcount;i++)
				for(int j=0;j<mcount;j++)
					graph[i+1][j+mcount+1] = 1;
			//begin min cost max flow
	        found = new boolean[graph.length];
	        flow = new int[graph.length][graph.length];
	        dist = new int[graph.length+1];
	        pre = new int[graph.length];
	        pi = new int[graph.length];
	        int totflow = 0, totcost = 0;
	    	while (search(source, sink,graph.length)) {
	    	    int amt = INF;
	    	    for (int x = sink; x != source; x = pre[x])
	    	    	amt = Math.min(amt, flow[x][pre[x]] != 0 ? flow[x][pre[x]] : graph[pre[x]][x] - flow[pre[x]][x]);
	    	    for (int x = sink; x != source; x = pre[x]) {
	    	    	if (flow[x][pre[x]] != 0) {
	    	    		flow[x][pre[x]] -= amt;
	    	    		totcost -= amt * cost[x][pre[x]];
	    	    	} else {
	    	    		flow[pre[x]][x] += amt;
	    	    		totcost += amt * cost[pre[x]][x];
	    	    	}
	    	    }totflow += amt;
	    	}System.out.println(totcost);
	    }
	}
	private static boolean search(int source, int sink, int N) {
		Arrays.fill(found, false);
		Arrays.fill(dist, INF);
		dist[source] = 0;
		while (source != N) {
		    int best = N;
		    found[source] = true;
		    for (int k = 0; k < N; k++) {
			if (found[k]) continue;
			if (flow[k][source] != 0) {
			    int val = dist[source] + pi[source] - pi[k] - cost[k][source];
			    if (dist[k] > val) {
				dist[k] = val;
				pre[k] = source;
			    }
			}
			if (flow[source][k] < graph[source][k]) {
			    int val = dist[source] + pi[source] - pi[k] + cost[source][k];
			    if (dist[k] > val) {
				dist[k] = val;
				pre[k] = source;
			    }
			}
			
			if (dist[k] < dist[best]) best = k;
		    }
		    source = best;
		}
		for (int k = 0; k < N; k++)
		    pi[k] = Math.min(pi[k] + dist[k], INF);
		return found[sink];
	    }
}
