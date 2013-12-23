
import java.util.*;

public class Main{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int test  = in.nextInt();
		while(test-->0){
			int vmax = in.nextInt();
			int n = in.nextInt();
			int[][] bag = new int[n+1][4];
			int[][] weights = new int[n+1][4];
			int[] ptr = new int[n+1];
			int[] sack = new int[vmax+1];
			for(int i=1; i<=n; i++){
				int v = in.nextInt();
				int c = in.nextInt();
				int u = in.nextInt();
				if(u!=0){
					weights[u][ptr[u]+1] = v;
					bag[u][ptr[u]+1] = v*c;
					ptr[u]++;
				} else {
					weights[i][0] = v;
					bag[i][0] = v*c;
				}
			}
			Arrays.fill(sack, -1);
			sack[0] = 0;
			int[] changed;
			for(int i=1;i<=n; i++){
				changed = new int[sack.length];
				Arrays.fill(changed, -1);
				for(int j=1; j<(1<<3); j++){
					int w1 = weights[i][0];
					int c1 = bag[i][0];
					int mask = 1;
					for(int k=0;k<3;k++){
						if(((mask<<k)&j)>0){
							w1+=weights[i][k+1];
							c1+=bag[i][k+1];
						}
					}
					for(int k= sack.length-1; k>=w1; k--){
						if(sack[k-w1]!=-1){
							changed[k] = Math.max(sack[k], Math.max(sack[k-w1] + c1, changed[k]));
						}
					}
				}
				for(int k = 0;k<sack.length;k++){
					if(changed[k] > sack[k]){
						sack[k] = changed[k];
					}
				}
			}
			int ans = 0;
			for(int i: sack){
				ans = Math.max(ans, i);
			}
			System.out.println(ans);
		}
	}
}


