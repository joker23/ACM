import java.util.*;
public class Main {
	// need bellman ford...
	static final int INF = 100000;
	public static void main(String[] args){
		Scanner in =  new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int N = in.nextInt(),M=in.nextInt(),W = in.nextInt();
			int[] d = new int[N+1];
			int[] p = new int[N+1];
	
			Edge[] e = new Edge[M*2+W]; //Fill this with edges
			int count=0;
			while(M-->0){
				int a = in.nextInt(),b = in.nextInt(),c=in.nextInt();
				e[count++] = new Edge(a,b,c);
				e[count++] = new Edge(b,a,c);
			} while(W-->0){
				e[count++] = new Edge(in.nextInt(),in.nextInt(),-in.nextInt());
			}boolean flag = false;
			
			Arrays.fill(d, INF);
			Arrays.fill(p, -1);
			d[1] = 0;
			//Relax weights n-1 times
			for(int i=0;i < N-1;i++){
				for(int j=0;j < e.length;j++){
					int u = e[j].u, v = e[j].v, w = e[j].w;
					if(d[u] + w < d[v]){
						d[v] = d[u] + w;
						p[v] = u;
					}
				}
			} for(int i=0;i < e.length;i++){
				int u = e[i].u, v = e[i].v,w = e[i].w;
				if(d[u] + w < d[v]){
					flag = true;
					break;
				}
			} if(flag) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	private static class Edge{
		int u,v,w;
		public Edge(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
}
