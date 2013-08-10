import java.util.*;
public class Main {
	public static final int INF = -1;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int l = in.nextInt(),n = in.nextInt(), b = in.nextInt();
		int[] dp = new int[l+1];
		int[] budget = new int[l+1];
		Track[] tracks = new Track[n];
		Arrays.fill(dp, INF);
		for(int i=0;i<n;i++){
			tracks[i] = new Track(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
		}Arrays.sort(tracks);
		dp[0] = 0;
		for(int i=0;i<tracks.length;i++){
			if(tracks[i].x+tracks[i].w<=l&&budget[tracks[i].x]+tracks[i].c<=b){
				if(dp[tracks[i].x]!=-1){
					if(dp[tracks[i].x]+tracks[i].f>dp[tracks[i].x+tracks[i].w]){
						dp[tracks[i].x+tracks[i].w] = dp[tracks[i].x]+tracks[i].f;
						budget[tracks[i].x+tracks[i].w] = budget[tracks[i].x]+tracks[i].c;
					}
				}
			}
		}
		System.out.println(dp[l]);
	}
	public static class Track implements Comparable<Track>{
		Integer x,w,f,c;
		public Track(int x, int w, int f,int c){
			this.x = x;
			this.w = w;
			this.f = f;
			this.c = c;
		}
		public int compareTo(Track t){
			return this.x.compareTo(t.x);
		}
	}
}
